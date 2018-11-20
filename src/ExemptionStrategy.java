public class ExemptionStrategy implements BillingStrategy {
    public double getActualPrice(Product originalProduct) {
        double originalPrice = originalProduct.price;
        Tax tax = new Tax(0);//medical products exemption
        return (originalPrice + ((tax.getRateOfInterest()*originalPrice)/100))*originalProduct.quantity;
    }
}
