import java.util.ArrayList;

public class Customer {

    private ArrayList<Product> products;

    public Customer() {
        this.products = new ArrayList();
    }

    public  void addProduct(Product item){
        products.add(item);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
