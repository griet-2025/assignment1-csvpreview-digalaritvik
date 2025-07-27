package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreviewer {

    public static void main(String[] args) {
        // Path to the CSV file
        String csvFilePath = "dataset/dataset.csv";
        String row;
        String delimit = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String header = reader.readLine();
            if (header == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            // Display column headers
            String[] columnHeaders = header.split(delimit);
            System.out.println("Columns:");
            for (String header1 : columnHeaders) {
                System.out.print(header1 + " ");
            }
            System.out.println("\nTotal columns: " + columnHeaders.length);
            System.out.println("\nFirst 5 Records:\n");

            int recordCount = 0;

            // Read and display the first 5 data rows
            while ((row = reader.readLine()) != null && recordCount < 5) {
                String[] recordFields = row.split(delimit);
                System.out.println(String.join(" ", recordFields));
                recordCount++;
            }

            // Count the remaining records
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