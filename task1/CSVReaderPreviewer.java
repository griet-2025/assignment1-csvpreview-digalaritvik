package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreviewer {

    public static void main(String[] args) {
        String csvPath = "C:\\Users\\Ritwik\\Downloads\\dataset.csv";
        String lineText;
        int totalRows = 0;
        int totalColumns = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvPath))) {
            if ((lineText = bufferedReader.readLine()) != null) {
                String[] headerFields = lineText.split(",");
                totalColumns = headerFields.length;
                System.out.println("=== Data Preview ===");
                System.out.println("Columns:");
                for (String columnName : headerFields) {
                    System.out.print(columnName + "\t");
                }

                System.out.println("\nTotal Columns: " + totalColumns);
                System.out.println("\nFirst 10 Records:");

                int previewLimit = 10;

                while ((lineText = bufferedReader.readLine()) != null && previewLimit > 0) {
                    String[] rowFields = lineText.split(",");
                    for (String field : rowFields) {
                        System.out.print(field + "\t");
                    }
                    System.out.println();
                    totalRows++;
                    previewLimit--;
                }

                while ((lineText = bufferedReader.readLine()) != null) {
                    totalRows++;
                }

                System.out.println("\nTotal Records (excluding header): " + totalRows);
            }

        } catch (IOException ioEx) {
            System.err.println("Error reading the file:");
            ioEx.printStackTrace();
        }
    }
}
