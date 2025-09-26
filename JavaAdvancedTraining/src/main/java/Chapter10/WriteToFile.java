package Chapter10;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Lindokuhle Makanda
 * This class demonstrates creation of the .txt file
 */
public class WriteToFile {
    public static void main(String[] args) {
        String filePath =  "C:\\Users\\Lindokuhle Makanda\\Advanced Java\\java-advanced-2025\\JavaAdvancedTraining\\src\\main\\resources\\Hobbies.txt";
        File myFile = new File(filePath);


        try {
            myFile.createNewFile();
            //Write to file
            PrintStream pen = new PrintStream(myFile);//open the file for writing
            pen.println("Tennis");
            pen.println("Soccer");
            pen.println("Chess");
            pen.println("Dancing");

            pen.close();
        } catch (IOException e) {
            System.err.println("Failed to create file..." + e.getMessage() );
        }
    }





}
