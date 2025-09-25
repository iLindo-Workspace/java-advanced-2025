package Chaper8.Exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CityNotFound
{
    public static String[] cities = {
                            "Cape Town",
                            "Gqeberha",
                            "Pretoria",
                            "East London",
                            "Durban",
                            "Mbombela",
                            "Bloemfontein",
                            "Johannesburg"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int indexToSearch  = 0;
        try{
            System.out.print("Enter the index you would like to retrieve the City from: ");
            indexToSearch = sc.nextInt();

            System.out.println(cities[indexToSearch]);;
        }catch(ArrayIndexOutOfBoundsException  ex){
            int length = cities.length - 1;
            System.err.println("Error: " + ex.getMessage() +
                    "\nPositions from 0 to " + length + " are valid for searching");
        }catch(InputMismatchException ex){
            System.err.println("Error: invalid input");
        }finally{
            sc.close();
        }
    }

}
