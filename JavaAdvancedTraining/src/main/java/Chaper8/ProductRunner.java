package Chaper8;

import javax.naming.LimitExceededException;
import java.util.Scanner;

public class ProductRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double price;
        int qty;

        try {
            System.out.print("Enter price: ");
            price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            qty = sc.nextInt();


            Product objProduct = new Product("CK200", "Coke Zero", price, qty);

            objProduct.sell(5);
            objProduct.increasePrice(5);

            System.out.println(objProduct.toString());
        } catch (IllegalArgumentException | LowStockException | HighPriceIncreaseException ex) {
            System.err.println("Error: " + ex.getMessage());
        }finally {
            sc.close();;
        }




    }
}
