

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextToXmlConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text to convert to XML: ");
        String inputText = scanner.nextLine();

        System.out.print("Enter the XML tag name (e.g., message, note): ");
        String tagName = scanner.nextLine();

        System.out.print("Enter the output XML file name (e.g., note.xml): ");
        String fileName = scanner.nextLine();

        try {
            convertTextToXml(inputText, tagName, fileName);
            System.out.println("Text successfully converted to XML and saved as " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }

    public static void convertTextToXml(String text, String tagName, String fileName) throws IOException {
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                             "<" + tagName + ">" + text + "</" + tagName + ">";
                             
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bWriter = new BufferedWriter(fw);
        bWriter.write(xmlContent);
        bWriter.flush();
        bWriter.close();

    }
}