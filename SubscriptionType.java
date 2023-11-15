
public enum SubscriptionType {
    BASIC(2.99, "Basic access to the platform with standard video quality."),
    STANDARD(4.99, "HD video quality and the ability to watch on multiple screens."),
    PREMIUM(9.99, "4K video quality, the ability to watch on multiple screens, and exclusive features.");

    private final double cost;
    private final String description;


    SubscriptionType(double cost, String description) {
        this.cost = cost;
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }
    
}

