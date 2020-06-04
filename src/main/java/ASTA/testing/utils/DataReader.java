package ASTA.testing.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataReader {

    private CustomFile customFile;

    public DataReader() {
        customFile = new CustomFile();
    }

    public void getDataFromFile() {

        XSSFWorkbook excelWBook;
        XSSFSheet excelWSheet;
        XSSFCell cell;
        String sheetName = BaseProperties.SHEET_NAME;
        String cellData;

        try {
            FileInputStream excelFile = new FileInputStream(customFile.getResourceFilePath(BaseProperties.DATA_FILE_NAME));

            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
            cell = excelWSheet.getRow(0).getCell(0);
            cellData = cell.getStringCellValue();
            System.out.println(cellData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
