package Chapter10;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromExcel {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lindokuhle Makanda\\Advanced Java\\java-advanced-2025\\JavaAdvancedTraining\\src\\main\\resources\\Student Results.xlsx";


        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook myWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = myWorkbook.getSheetAt(0);

//            System.err.println("Name\tTest 1\tTest 2\tTest 3");
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//                Row row = sheet.getRow(i);
//
//                for(int column = 0; column < row.getLastCellNum(); column++){
//                    Cell cell = row.getCell(column);
//                    System.out.print(cell + " \t");
//                }
//                System.out.println();
//            }
            int count = 0;
            for(Row row : sheet){
                for(Cell c : row) {

                    switch (c.getCellType()) {
                        case STRING -> System.out.print(c.getStringCellValue() + "\t\t");
                        case NUMERIC -> System.out.print(c.getNumericCellValue() + "\t\t");
                        default -> System.err.println("Invalid cell type. " + c.getCellType());

                    }
                }
                System.out.println();
            }

            fileInputStream.close();;
            myWorkbook.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}
