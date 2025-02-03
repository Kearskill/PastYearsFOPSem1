package paper2024;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Q5 {
    public static void main(String[] args) {
        String filePath = "src/paper2024/participants.txt";
        String outputPath = "src/paper2024/output.txt";
        String [][] participants = new String[4][4];
        try(BufferedReader br = new BufferedReader (new FileReader(filePath))){
            String line;
            int row = 0;
            while (((line = br.readLine()) != null) && row<4){
                String[] parts = line.split(",");
                if (parts.length == 4){
                    for (int i = 0; i < parts.length; i++) {
                        participants[row][i] = parts[i].trim();
                    }
                    row++;
                }
            }
        } catch(IOException err){
            System.out.println("An issue has occured");
        }

        for (String[] participant : participants) {
            System.out.printf("%-15s %-3s %-3s %-40s%n",
                    participant[0], // Name\n +
                    participant[1], // Gender\n +
                    participant[2], // Age\n" +
                    participant[3]  // Address\n"
            );
        }

        for (int i = 0; i < participants.length; i++) {
            participants[i][3] = participants[i][3].replaceAll("\\s","").toLowerCase().trim();
        }

        boolean[] isPaired = new boolean[participants.length];
        int pairCount = 0;

        for (int i = 0; i < 4; i++) {
            if(!isPaired[i]){
                for (int j = i+1; j < 4; j++) {
                    if(!isPaired[j]){
                        if (participants[i][3].equals(participants[j][3]) && !participants[i][1].equals(participants[j][1])){
                            isPaired[i] = true;
                            isPaired[j] = true;
                            pairCount++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(pairCount);

        if (pairCount ==2){
            System.out.println("Pairing is successs");
            String[] seats ={"a", "b", "c", "d"};
            String[][] seating = new String[4][4];

            int seatIndex = 0;
            for (int i = 0; i < seating.length; i++) {
                if (!isPaired[i]){
                    continue;
                }
                for (int j = 1+i; j < seating.length; j++) {
                    if(isPaired[j] && participants[i][3].equals(participants[j][3]) && !participants[i][1].equals(participants[j][1])) {
                        seating[seatIndex][0] = seats[seatIndex];
                        seating[seatIndex][1] = participants[i][0];
                        seating[seatIndex][2] = participants[i][2];
                        seatIndex++;
                        seating[seatIndex][0] = seats[seatIndex];
                        seating[seatIndex][1] = participants[j][0];
                        seating[seatIndex][2] = participants[j][2];
                        seatIndex++;
                    }
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))){
                for (String[] seat : seating) {
                    bw.write("seat: "+ seat[0] + " : " + seat[1] + ", " + seat[2] + " years old");
                    bw.newLine();
                }
                System.out.println("Seating arrangement saved to " + outputPath);
            } catch (IOException err){
                System.out.println("File writing error.");
            }
        } else{
            System.out.println("Pairing is unsuccessful");
        }
    }
}
