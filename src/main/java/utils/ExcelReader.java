package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelReader {
    public void readExcelFile() throws Exception{
        //Read the file
        FileInputStream fis = new FileInputStream(new File("/Users/manash.sarma/Downloads/StudentData.xlsx"));
        //Get Workbook
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        //Get Sheet
        XSSFSheet sheet = wb.getSheet("student");
        //Read row
        Iterator<Row> rowIterator = sheet.iterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            //Read cell
            Iterator<Cell> cellIterator =row.cellIterator();
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                //Print cell data
                switch (cell.getCellType()){
                    case STRING:
                        System.out.print(cell.getStringCellValue() + " ");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " ");
                        break;
                }
            }
            System.out.println();
        }
        fis.close();
    }

    public static void main(String[] args) throws Exception {
        new ExcelReader().readExcelFile();
        System.out.println("end of class...");
    }
    //Create a new branch from develop/master
    //Make changes in your branch
    //Commit your changes [Now the changes are in your branch]
    //Create Pull request (PR) to merge changes from your branch to master branch

}
