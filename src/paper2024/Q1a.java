package paper2024;
import java.util.Scanner;

public class Q1a {
    public static void main(String[] args) {
        // Write a program that accept numbers as user input until they press X to quit. As the output,
        // it should display the count of positive, negative and zeroes entered.
        Scanner sc = new Scanner(System.in);
        int posCnt = 0;
        int negCnt = 0;
        int zeroCnt = 0;

        System.out.println("Input a number (Press X to exit): ");
        String userInput = sc.nextLine();
        while(!(userInput.equals("x") || userInput.equals("X"))){
            int temp = Integer.parseInt(userInput);
            if(temp >0){ // +ve
                posCnt++;
            } else if (temp<0){
                negCnt++;
            } else{
                zeroCnt++;
            }

            System.out.println("Input a number (Press X to exit): ");
            userInput = sc.nextLine();
        }

        System.out.println("Users has inputted:");
        System.out.println("Positive number counts : " + posCnt);
        System.out.println("Negative number counts : " + negCnt);
        System.out.println("Zero counts : " + zeroCnt);
    }
}
