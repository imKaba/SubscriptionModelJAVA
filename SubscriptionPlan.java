import java.util.UUID;

public abstract class SubscriptionPlan implements Subscribable {
  private String planID;
  private SubscriptionType planName;
  private double planCost;
  private TimerType timer;


  public SubscriptionPlan(SubscriptionType name, double cost) {
    this.planID = UUID.randomUUID().toString();
    this.planName = name;
    this.planCost = cost;
  }

  public double calculateSubscriptionCost(SubscriptionType subscriptionType){
    return subscriptionType.getCost() * timer.getMonth();
  }

  public String getPlanID() {
      return planID;
  }

  public SubscriptionType getPlanName() {
      return planName;
  }

  public double getPlanCost() {
      return planCost;
  }
}
