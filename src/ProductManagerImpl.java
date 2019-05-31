import interFace.ProductManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductManagerImpl implements ProductManager<Product> {
    ArrayList<Product> products = new ArrayList<>();
    int count = 0;

    public ProductManagerImpl() {
    }

    @Override
    public int addProduct(Product product) {
        for(Product st : products) {
            if (st.getId() == product.getId()) {
                return -1;
            } else {
                if(st.getName().equals(product.getName())
                        && (st.getPrice() == product.getPrice()) && (st.getDescription().equals(product.getDescription()))) {
                    return 0;
                }
            }
        }
        products.add(product);
        count ++;
        return 1;
    }

    @Override
    public boolean editProduct(Product product) {
        for (Product st : products) {
            if (st.getId() == product.getId()) {
                st.setStatus(product.getStatus());
                st.setPrice(product.getPrice());
                st.setDescription(product.getDescription());
                st.setName(product.getName());
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeProduct(int id) {
        for (Product st: products) {
            if(st.getId() == id) {
                products.remove(st);
                count --;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean searchProduct(int id) {
        for (Product st : products) {
            if (st.getId() == id) {
                display(st);
                return true;
            }
        }

        return false;


    }

    @Override
    public void sortProduct() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

    }

    @Override
    public void displayProduct() {
        for (Product product : products) {
           display(product);
        }
    }

    public void display(Product product) {
        System.out.println("ID: " + product.getId()
                + " | Name: " + product.getName()
                +" | Description: " + product.getDescription()
                +" | Price: "
                +product.getPrice()
                + "| Status "
                + product.getStatus()
                +"\n");
    }
}
