package paper2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q3 {
    public static void main(String[] args) { // driver main
        String inputFile = "src/paper2024/oaiset.csv";
        OAIRecord[] data = new OAIRecord[50];
        System.out.println("Loading dataset...");
        loadRecord(inputFile, data);
        System.out.println("The curated record is as follow:");
        printRecord(cleanRecord(data));
        System.out.println("\nThe summary report is as follow:");
        reportData(cleanRecord(data));
    }
    public static void loadRecord(String filename, OAIRecord[] data) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;

            // Read the header and ignore it
            br.readLine();

            while ((line = br.readLine()) != null && index < data.length) {
                String[] fields = line.split(","); // -1 keeps empty fields

                if (fields.length != 13) {
                    System.out.println("Skipping invalid record at line " + (index + 2));
                    continue;
                }

                data[index] = new OAIRecord(
                        fields[0], fields[1], fields[2], fields[3], fields[4],
                        fields[5], fields[6], fields[7], fields[8], fields[9],
                        fields[10], fields[11], fields[12]
                );

                index++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void printRecord(OAIRecord[] records) {
        for (OAIRecord record : records) {
            if (record != null) {
                System.out.println(record);
            }
        }
    }

    public static OAIRecord[] cleanRecord(OAIRecord[] records) {
        int count = 0;
        for (OAIRecord record : records) {
            if (record != null && !"deleted".equals(record.getStatus())) {
                count++;
            }
        }

        OAIRecord[] cleanedRecords = new OAIRecord[count];
        int index = 0;
        for (OAIRecord record : records) {
            if (record != null && !"deleted".equals(record.getStatus())) {
                cleanedRecords[index++] = record;
            }
        }

        return cleanedRecords;
    }

    public static void reportData(OAIRecord[] records) {
        System.out.println("Total valid records: " + records.length);
    }
}

class OAIRecord{
    private final String doi;
    private final String title;
    private final String subject;
    private final String author1;
    private final String author2;
    private final String author3;
    private final String author4;
    private final String author5;
    private final String author6;
    private final String author7;
    private final String author8;
    private final String keyword;
    private final String status;

    public OAIRecord(String doi, String title, String subject, String author1, String author2, String author3, String author4, String author5, String author6, String author7, String author8, String keyword, String status) {
        this.doi = doi;
        this.title = title;
        this.subject = subject;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.author4 = author4;
        this.author5 = author5;
        this.author6 = author6;
        this.author7 = author7;
        this.author8 = author8;
        this.keyword = keyword;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

