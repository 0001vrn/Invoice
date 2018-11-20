public class NormalStrategy implements BillingStrategy {
    public double getActualPrice(Product originalProduct) {
        double originalPrice = originalProduct.price;
        Tax tax = new Tax(20);
        return (originalPrice + ((tax.getRateOfInterest()*originalPrice)/100))*originalProduct.quantity;
    }
}
