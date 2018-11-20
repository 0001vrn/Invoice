import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceTest {

    Invoice invoice;
    Customer customer;

    @Before
    public void init(){
        invoice = new Invoice();
        customer = new Customer();
    }

    @Test
    public void WhenProductsExemptedFromTax(){
        Product book = new Product("1,book,30,0");

        Product chocolate = new Product("1,chocolate,1,0");

        customer.addProduct(book);
        customer.addProduct(chocolate);

        invoice.printInvoice(customer);

        assertEquals(37.2, invoice.getTotal(),0.001);
        assertEquals(6.2, invoice.getSales_tax(),0.001);
    }

    @Test
    public void WhenProductsNotExemptedFromTax() {

        Product bottle_of_wine = new Product("1,bottle_of_wine,20,0");

        Product box_of_headache_pills = new Product("2,box_of_headache_pills,4,1");

        Product box_of_pens = new Product("1,box_of_pens,10,0");

        customer.addProduct(bottle_of_wine);
        customer.addProduct(box_of_headache_pills);
        customer.addProduct(box_of_pens);

        invoice.printInvoice(customer);


        assertEquals(44, invoice.getTotal(),0.001);
        assertEquals(6, invoice.getSales_tax(),0.001);
    }


    @Test
    public void WhenSingleProductExemptedFromTax(){
        Product pen = new Product("1,pen,5,0");

        customer.addProduct(pen);

        invoice.printInvoice(customer);

        assertEquals(6, invoice.getTotal(),0.001);
        assertEquals(1, invoice.getSales_tax(),0.001);
    }
}