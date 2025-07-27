package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreviewer {

    public static void main(String[] args) {
        String csvFilePath = "dataset/dataset.csv";
        String row;
        String delimit = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String headerRow = reader.readLine();
            if (headerRow == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            String[] columnHeaders = headerRow.split(delimit);
            System.out.println("Columns:");
            for (String header : columnHeaders) {
                System.out.print(header + " ");
            }
            System.out.println("\nTotal columns: " + columnHeaders.length);
            System.out.println("\nFirst 5 Records:\n");

            int recordCount = 0;

            while ((row = reader.readLine()) != null && recordCount < 5) {
                String[] recordFields = row.split(delimit);
                System.out.println(String.join(" ", recordFields));
                recordCount++;
            }

            while (reader.readLine() != null) {
                recordCount++;
            }

            System.out.println("\nTotal Records (excluding header): " + recordCount);

        } catch (IOException exception) {
            System.err.println("An error occurred while reading the file:");
            exception.printStackTrace();
        }
    }
}