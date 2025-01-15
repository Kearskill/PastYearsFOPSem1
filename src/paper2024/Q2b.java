package paper2024;

import java.util.Scanner;

public class Q2b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter your age: ");
            int age = sc.nextInt();
            checkAge(age);
        } catch (InvalidAgeException err) {
            System.out.println("Exception " + err.getMessage());
        } catch (Exception err) {
            System.out.println("Invalid input! Please enter a valid number.");
        } finally {
            sc.close();
            System.out.println("Age verification completed!");
        }
    }

    private static void checkAge(int age) throws InvalidAgeException {
        if (age >= 18) {
            System.out.println("Your age are higher than 18.");
        } else {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }
}

/*Create a Java program that uses custom exceptions. Write a class InvalidAgeException that
extends Exception. Then, create a method checkAge(int age) that throws an InvalidAgeException
if the age is less than 18. In your main method, call checkAge with a user-provided age and use
a try-catch block to handle the custom exception.*/

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}