public class Product {
    public String name;
    public Category type;
    public double price;
    public int quantity;

    public Product(String val) {
        String[] arr = val.split(",");
        this.quantity = Integer.parseInt(arr[0]);
        this.name = arr[1];
        this.price = Double.parseDouble(arr[2]);
        if(arr[3].equals("1")) {
            this.type = Category.MEDICAL;
        } else{
            this.type = Category.NON_MEDICAL;
        }
    }
}
