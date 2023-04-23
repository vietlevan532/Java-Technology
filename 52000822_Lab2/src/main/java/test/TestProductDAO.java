package test;

import java.util.Scanner;

import dao.ProductDao;
import model.Product;

public class TestProductDAO {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        menu();
    }

    public static void menu() {
        int chon = 1;
        while (chon != 6) {
            System.out.println("\t\t\t\t\t\t\t\t MANAGE PRODUCT" + "\n" +
                    "**************************************************************************" + "\n" +
                    "**  1. Read product list                                                **" + "\n" +
                    "**  2. Read a product by input id                                       **" + "\n" +
                    "**  3. Add a new product, the result is the product id (auto increment) **" + "\n" +
                    "**  4. Update                                                           **" + "\n" +
                    "**  5. Delete a product                                                 **" + "\n" +
                    "**  6. Exit.                                                            **" + "\n" +
                    "**************************************************************************");

            int id;
            String color, name;
            float price;

            ProductDao productDao = new ProductDao();
            Scanner scan = new Scanner(System.in);
            chon = scan.nextInt();

            switch (chon) {
                case 1:// select All
                    System.out.println(productDao.readAll());
                    break;

                case 2:// selectByID
                    System.out.println("Enter product ID you want to read detail: ");
                    id = scan.nextInt();
                    System.out.println(productDao.read(id));
                    break;

                case 3:// add
                    System.out.println("Enter product ID: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter product name: ");
                    name = scan.nextLine();
                    System.out.println("Enter product price: ");
                    price = scan.nextFloat();
                    scan.nextLine();
                    System.out.println("Enter product color: ");
                    color = scan.nextLine();
                    productDao.add(new Product(name, color, price, id));

                    break;
                case 4:// update
                    System.out.println("Enter product's id need update: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter product's new name: ");
                    name = scan.nextLine();
                    System.out.println("Enter product's new price: ");
                    price = scan.nextFloat();
                    scan.nextLine();
                    System.out.println("Enter product's new color: ");
                    color = scan.nextLine();
                    productDao.update(new Product(name, color, price, id));
                    break;

                case 5:// delete
                    System.out.println("Enter the product ID you want to delete: ");
                    int del = scan.nextInt();
                    String temp = String.valueOf(productDao.read(del));
                    if (!productDao.delete(del)) {
                        System.out.println("Product not available!");
                    } else {
                        System.out.println("Deleted: " + temp);
                    }
                    break;

                case 6:// Exit
                    System.out.println("Exiting Program...");
                    break;
            }

        }

    }

}
