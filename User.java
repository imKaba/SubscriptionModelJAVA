import java.util.UUID;
import java.time.LocalDate;

public class User {
  private String userID;
  private String userName;
  private String userEmail;
  private SubscriptionType userSub;
  private LocalDate subscriptionExpirationDate;
  // private double discount;


  public User(String name, String email, SubscriptionType subType, TimerType timer){
    this.userID = UUID.randomUUID().toString();
    this.userName = name;
    this.userEmail = email;
    this.userSub = subType;
    this.subscriptionExpirationDate = LocalDate.now().plusMonths(timer.getMonth());

  }

  public void changeSubscriptionPlan(SubscriptionType newSubscriptionType) {
    this.userSub = newSubscriptionType;
    System.out.println("Subscription plan updated to: " + newSubscriptionType);
  }

  public void changeTimerType(TimerType newTimerType) {
    this.subscriptionExpirationDate = LocalDate.now().plusMonths(newTimerType.getMonth());
    System.out.println("Period plan updated to: " + newTimerType);
  }

  public Boolean isSubExpired() {
    return LocalDate.now().isAfter(this.subscriptionExpirationDate);
  }
  

  public String getUserID() {
    return userID;
  }

  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getUserEmail() {
    return userEmail;
  }
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
  public SubscriptionType getUserSub() {
    return userSub;
  }
  public void setUserSub(SubscriptionType userSub) {
    this.userSub = userSub;
  }

  public LocalDate getSubscriptionExpirationDate() {
      return subscriptionExpirationDate;
  }



  public String toString(){
    return "\n=================================================\n"
            + "Username: " + this.userName
            + "\nUserID: "  + this.userID
            + "\nEmail: "  + this.userEmail
            + "\nSubscription plan: " + this.userSub
            + "\n" + this.userSub.getDescription()
            + "\nCost : $" + (userSub.getCost() * 30.0) + "/month"
            + "\nSubscription period: " + getSubscriptionExpirationDate()
            + "\n=================================================\n";
  }
}
