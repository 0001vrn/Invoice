import java.util.LinkedList;
import java.util.List;

public class Customer {

    private List<Product> products;

    public Customer() {
        this.products = new LinkedList<>();
    }

    public  void addProduct(Product item){
        products.add(item);
    }

    public List<Product> getProducts() {
        return products;
    }
}
