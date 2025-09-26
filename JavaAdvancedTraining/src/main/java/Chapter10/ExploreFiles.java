package Chapter10;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author Lindokuhle Makanda
 * FileSystem, File, Path
 */
public class ExploreFiles {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("C:\\Users\\Lindokuhle Makanda\\Consent_Form.pdf");
        System.out.println("Name: " + path.getFileName());
        System.out.println("Name Count: " + path.getNameCount());
        System.out.println("Parent: " + path.getParent());
        System.out.println("Root: " + path.getRoot());
        System.out.println("Absolute Path?: " + path.isAbsolute());


    }
}
