public class PremiumPlan extends SubscriptionPlan {

  PremiumPlan() {
    super(SubscriptionType.PREMIUM, SubscriptionType.PREMIUM.getCost());
  }
  
}
