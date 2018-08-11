public class Product {
    public String name;
    public Category type;
    public double price;
    public int quantity;

    public void build(String val){
        String[] arr = val.split(",");
        quantity = Integer.parseInt(arr[0]);
        name = arr[1];
        price = Double.parseDouble(arr[2]);
        if(arr[3].equals("1")) {
            type = Category.MEDICAL;
        } else{
            type = Category.NON_MEDICAL;
        }
    }
}
