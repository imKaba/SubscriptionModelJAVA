import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusinessModel {
    private static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create User");
            System.out.println("2. List Users");
            System.out.println("3. Update User Subscription Plan");
            System.out.println("4. Update User Period Plan");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    listUsers();
                    break;
                case 3:
                    updateUserSubscription(scanner);
                    break;
                case 4:
                    updateUserPeriodPlan(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while(choice != 1 & choice != 2 & choice != 3 & choice !=4 & choice != 5);
    } 

    private static void createUser(Scanner scanner) {
        int subscriptionChoice=0;
        System.out.println("Enter your username: ");
        String userName = scanner.nextLine();

        String userEmail;
        do {
            System.out.println("Enter a valid email address: ");
            userEmail = scanner.nextLine();
        } while (!userEmail.contains("@"));

        do {
            System.out.println("Choose your subscription type:");
            System.out.println("1. BASIC($" + SubscriptionType.BASIC.getCost() + "/month)");
            System.out.println("2. STANDARD($" + SubscriptionType.STANDARD.getCost() + "/month)");
            System.out.println("3. PREMIUM($" + SubscriptionType.PREMIUM.getCost() + "/month)");
            subscriptionChoice = scanner.nextInt();
        } while (subscriptionChoice != 1 & subscriptionChoice != 2 & subscriptionChoice !=3 );

        SubscriptionType subType = getSubscriptionType(subscriptionChoice);

        do {
            System.out.println("Choose your period plan:");
            System.out.println("1. One Month");
            System.out.println("2. Three Month");
            System.out.println("3. Six Month");
            System.out.println("4. One Year");

            subscriptionChoice = scanner.nextInt();
        } while (subscriptionChoice != 1 & subscriptionChoice != 2 & subscriptionChoice !=3 & subscriptionChoice !=4);

        TimerType timer = getTimerType(subscriptionChoice);
        
        User subscriber = new User(userName, userEmail, subType, timer);
        userList.add(subscriber);
        System.out.println("User created: " + subscriber);
    }

    private static void listUsers() {
        if (userList.isEmpty()) {
            System.out.println("No users to display.");
        } else {
            System.out.println("List of Users:");
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    private static SubscriptionType getSubscriptionType(int choice) {
        switch (choice) {
            case 1:
                return SubscriptionType.BASIC;
            case 2:
                return SubscriptionType.STANDARD;
            case 3:
                return SubscriptionType.PREMIUM;
            default:
                throw new IllegalArgumentException("Invalid Option");
        }
    }

    private static TimerType getTimerType(int choice) {
        switch (choice) {
            case 1:
                return TimerType.ONE_MONTH;
            case 2:
                return TimerType.THREE_MONTH;
            case 3:
                return TimerType.SIX_MONTH;
            case 4:
                return TimerType.ONE_YEAR;
            default:
                throw new IllegalArgumentException("Invalid Option");
        }
    }

    private static User findUserByID(String userID) {
        for (User user : userList) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    private static void updateUserSubscription(Scanner scanner) {
        System.out.println("Enter the user's ID to update subscription: ");
        String userIDToUpdate = scanner.nextLine();
    
        User userToUpdate = findUserByID(userIDToUpdate);
    
        if (userToUpdate == null) {
            System.out.println("User not found.");
            return;
        }
    
        System.out.println("Current Subscription: " + userToUpdate.getUserSub());
        System.out.println("Choose the new subscription type:");
        System.out.println("1. BASIC");
        System.out.println("2. STANDARD");
        System.out.println("3. PREMIUM");
    
        int newSubscriptionChoice = scanner.nextInt();
        SubscriptionType newSubscriptionType = getSubscriptionType(newSubscriptionChoice);
    
        userToUpdate.changeSubscriptionPlan(newSubscriptionType);
    }

    private static void updateUserPeriodPlan(Scanner scanner) {
        System.out.println("Enter the user's ID to update period plan: ");
        String userIDToUpdate = scanner.nextLine();
    
        User userToUpdate = findUserByID(userIDToUpdate);
    
        if (userToUpdate == null) {
            System.out.println("User not found.");
            return;
        }
    
        System.out.println("Current Period Plan: " + userToUpdate.getSubscriptionExpirationDate());
        System.out.println("Choose the new period plan:");
        System.out.println("1. One Month");
        System.out.println("2. Three Month");
        System.out.println("3. Six Month");
        System.out.println("4. One Year");
    
        int newSubscriptionChoice = scanner.nextInt();
        TimerType newTimerType = getTimerType(newSubscriptionChoice);
    
        userToUpdate.changeTimerType(newTimerType);
    }
    
    
}
