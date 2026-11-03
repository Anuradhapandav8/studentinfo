
package NumberGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Gamming {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rc = new Random();

        int round = 1;
        int totalAttempts = 0;
        String choice = "yes";

        while (choice.equalsIgnoreCase("yes")) {

            int computerNum = rc.nextInt(100) + 1;
            int userNum = 0;
            int attempts = 0;
            boolean win = false;

            System.out.println("\nWelcome to Number Guessing Game");
            System.out.println("Guess a number between 1 to 100");
            System.out.println("You have only 7 attempts");

            while (attempts < 7) {

                try {

                    System.out.print("Enter your number: ");
                    userNum = sc.nextInt();

                    if (userNum < 1 || userNum > 100) {
                        System.out.println("Please enter number between 1 to 100");
                    }

                    else {

                        attempts++;
                        totalAttempts++;

                        if (computerNum == userNum) {

                            System.out.println("Congratulations! Correct Guess");
                            System.out.println("You guessed in " + attempts + " attempts");
                            win = true;
                            break;

                        }

                        else if (userNum < computerNum) {

                            System.out.println("Your number is too low");

                        }

                        else {

                            System.out.println("Your number is too high");

                        }

                        System.out.println("Remaining attempts: " + (7 - attempts));

                    }

                }

                catch (InputMismatchException e) {

                    System.out.println("Invalid input! Please enter only numbers");
                    sc.nextLine();

                }

            }

            if (win == false) {

                System.out.println("\nSorry! You lost the game");
                System.out.println("Correct number was: " + computerNum);

            }

            System.out.println("\nRound " + round + " completed");
            System.out.println("Total attempts: " + attempts);

            if (win == true) {
                System.out.println("Result: Win");
            }
            else {
                System.out.println("Result: Lose");
            }

            System.out.print("\nDo you want to play again? yes/no: ");
            choice = sc.next();

            round++;

        }

        System.out.println("\n===== Final Result =====");
        System.out.println("Total rounds: " + (round - 1));
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Thank you for playing!");

        sc.close();

    }

}
