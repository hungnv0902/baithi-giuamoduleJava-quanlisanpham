import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        ProductManagerImpl productManager = new ProductManagerImpl();

        do {
            menu();
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    Product product = inputProduct();
                    int result = productManager.addProduct(product);
                    if (result == -1) {
                        System.out.println("Trung ID");
                    } else if (result == 1) {
                        System.out.println("San pham da duoc them");
                    } else if(result == 0) {
                        System.out.println("San pham da ton tai");
                    }
                    break;
                }

                case 2: {
                    Product product = inputProduct();
                    boolean result = productManager.editProduct(product);
                    if (result) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Khong tim thay san pham");
                    }
                    break;
                }

                case 3:
                    System.out.println("Nhap ID");
                    int id = input.nextInt();
                    boolean check = productManager.removeProduct(id);
                    if(check) {
                        System.out.println("San pham da duoc xoa");
                    } else {
                        System.out.println("Khong tim thay san pham");
                    }
                    break;

                case 4:
                    productManager.sortProduct();
                    break;

                case 5:
                    productManager.displayProduct();
                    break;

                case 6:
                    System.out.println("Nhap ID");
                    int id1 = input.nextInt();
                    productManager.searchProduct(id1);
                    break;


            }
        } while (choice != 0);

    }

    private static void menu() {
        System.out.println("\n-Quan ly sinh vien-");
        System.out.println("1. Them moi");
        System.out.println("2. Sua");
        System.out.println("3. Xoa");
        System.out.println("4. Sap xep");
        System.out.println("5. Hien thi");
        System.out.println("6. Tim kiem");
        System.out.println("0. Thoat");
        System.out.println("Nhap vao chon lua: ");
    }

    private static Product inputProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ID :");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Nhap ten :");
        String name = input.nextLine();
        System.out.println("Nhap mo ta");
        String description = input.nextLine();
        System.out.println("Nhap gia :");
        int price = input.nextInt();
        input.nextLine();
        System.out.println("Nhap trang thai :");
        String status = input.nextLine();
        Product product = new Product(id,name,description,price,status);
        return product;
    }
}
