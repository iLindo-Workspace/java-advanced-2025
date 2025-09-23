package Chaper8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Lindokuhle Makanda
 */

public class Exceptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "";
        int numerator, denominator;
        double quotient = 0;

        try{
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            System.out.print("Enter numerator: ");
            numerator = sc.nextInt();
            System.out.print("Enter denominator: ");
            denominator = sc.nextInt();

            quotient = numerator / denominator;

            System.out.println("Your name is " + name);
            System.out.println("The last letter of your name (" +   name + ") is (" + name.substring(4) + ")");
            System.out.println("Quotients " + quotient);
        }catch(InputMismatchException ex){
            System.err.println("Incorrect input type");

        }catch(ArithmeticException ex){
            System.err.println("Cannot divide by zero");
        }catch(StringIndexOutOfBoundsException ex){
            System.err.println("The last letter of (" + name + ") should be at position: "
                    + name.indexOf(name.substring(name.length() - 1))
                    + " (" + name.substring(name.length() - 1) + ")");

        }


    }
}
