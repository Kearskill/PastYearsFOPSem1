package paper2024;
import java.util.Random;

public class Q4 {
    public static void main(String[] args) {
        int[][] seatingPlan = initializeSeatingPlan();

        analyzeSeating(seatingPlan);
        System.out.println("Seating Plan: ");
        for (int i = 0; i < seatingPlan.length; i++) {
            for (int j = 0; j < seatingPlan[i].length; j++) {
                System.out.print(seatingPlan[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static int[][] initializeSeatingPlan(){
        Random rand = new Random();
        int[][] seat = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(rand.nextInt(0,2) == 1){ // still the same regardless  seatingPlan[i][j] = rand.nextInt(0,2); // 0 = empty, 1 = occupied
                    seat[i][j] = 1;
                } else{
                    seat[i][j] = 0;
                }
            }
        }

        return seat;
    }
    private static void analyzeSeating(int[][] seats){
        int total = 0;
        int bestRowCount = 0;
        int whichRow = 0;

        for (int i = 0; i < seats.length; i++) {
            int temp = 0;
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 1){
                    total++;
                    temp++;
                }

            }
            if (temp > bestRowCount){
                bestRowCount = temp;
                whichRow = i;
            }

        }
        System.out.println("Total Occupied Seats: " + total);
        System.out.println("Row with Most Occupied Seats: Row " + (whichRow + 1));
    }
}

/*Objective: Create and analyze a dynamically generated classroom seating
* plan using a two-dimensional array, control statements and static methods*/

