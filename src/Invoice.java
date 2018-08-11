public class Invoice {

    private double total;
    private double sales_tax;
    private double sum;

    BillingStrategy normalStrategy    = new NormalStrategy();
    BillingStrategy exemptionStrategy = new ExemptionStrategy();

    public Invoice() {
        this.total = 0;
        this.sales_tax = 0;
        this.sum = 0;
    }

    public void printInvoice(Customer customer){

        customer.getProducts().forEach(item ->
        {
            sum+=item.price*item.quantity;
            if(item.type == Category.MEDICAL){
                item.price = exemptionStrategy.getActualPrice(item);
            }
            else if(item.type == Category.NON_MEDICAL){
                double updatePrice = normalStrategy.getActualPrice(item);
                sales_tax+= updatePrice - item.price;
                item.price = updatePrice;
            }
            System.out.println(item.quantity+ " " + item.name+ ": " + item.price);
        });
        total = sum + sales_tax;
        System.out.println("Sales Tax: "+ sales_tax);
        System.out.println("Total: "+total);
    }

    public double getTotal() {
        return total;
    }

    public double getSales_tax() {
        return sales_tax;
    }
}
