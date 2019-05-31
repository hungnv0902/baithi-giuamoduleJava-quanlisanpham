package interFace;

public interface ProductManager<E> {
    int addProduct(E e);
    boolean editProduct(E e);
    boolean removeProduct(int id);
    boolean searchProduct(int id);
    void sortProduct();
    void displayProduct();
}
