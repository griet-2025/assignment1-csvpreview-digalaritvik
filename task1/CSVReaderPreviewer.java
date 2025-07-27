package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreviewer {

    public static void main(String[] args) {
        String fileLocation = "dataset/dataset.csv";
        String currentLine;
        String separator = ",";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {

            String headerLine = bufferedReader.readLine();
            if (headerLine == null) {
                System.out.println("CSV file is empty. Please check the file.");
                return;
            }

            System.out.println("=== File Content Preview ===\n");

            String[] headers = headerLine.split(separator);
            System.out.println("Header Columns:");
            for (String column : headers) {
                System.out.print(column + " ");
            }
            System.out.println("\nNumber of Columns: " + headers.length);
            System.out.println("\nTop 5 Rows:\n");

            int linesShown = 0;

            while ((currentLine = bufferedReader.readLine()) != null && linesShown < 5) {
                String[] values = currentLine.split(separator);
                System.out.println(String.join(" ", values));
                linesShown++;
            }

            int totalEntries = linesShown;
            while (bufferedReader.readLine() != null) {
                totalEntries++;
            }

            System.out.println("\nTotal Data Rows (excluding header): " + totalEntries);

        } catch (IOException e) {
            System.err.println("Unable to process the file due to an I/O error:");
            e.printStackTrace();
        }
    }
}
