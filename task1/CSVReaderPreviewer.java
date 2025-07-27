package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreviewer {

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        String lineContent;
        String separator = ",";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {

            String headerLine = fileReader.readLine();
            if (headerLine == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            String[] headers = headerLine.split(separator);
            System.out.println("Columns:");
            for (String col : headers) {
                System.out.print(col + " ");
            }
            System.out.println("\nTotal columns: " + headers.length);
            System.out.println("\nFirst 5 Records:\n");

            int dataLineCount = 0;

            while ((lineContent = fileReader.readLine()) != null && dataLineCount < 5) {
                String[] values = lineContent.split(separator);
                System.out.println(String.join(" ", values));
                dataLineCount++;
            }

            while (fileReader.readLine() != null) {
                dataLineCount++;
            }

            System.out.println("\nTotal Records (excluding header): " + dataLineCount);

        } catch (IOException ioException) {
            System.err.println("An error occurred while reading the file:");
            ioException.printStackTrace();
        }
    }
}
