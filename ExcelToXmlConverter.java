
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.ServerNotActiveException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;

public class ExcelToXmlConverter {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path to the Excel file: ");
        String excelFilePath = scanner.nextLine();

        System.out.print("Enter the output XML file name (e.g., output.xml): ");
        String fl = scanner.nextLine();

        convertExcelToXml(excelFilePath, fl);
        System.out.println("Excel successfully converted to XML and saved as " + fl);

    }

    public  static void convertExcelToXml(String excelFilePath, String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(excelFilePath); Workbook workbook = WorkbookFactory.create(fis); BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<sheets>\n");

            for (Sheet sheet : workbook) {
                writer.write("  <sheet name=\"" + sheet.getSheetName() + "\">\n");
                for (Row row : sheet) {
                    writer.write("    <row>\n");
                    for (Cell cell : row) {
                        writer.write("      <cell>" + cell.toString() + "</cell>\n");
                    }
                    writer.write("    </row>\n");
                }
                writer.write("  </sheet>\n");
            }
            writer.write("</sheets>");
        }
    }

}
