import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;
    private static final Scanner scanner = new Scanner(System.in);
    private static int roundsWon = 0;

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = generateRandomNumber(RANGE_START, RANGE_END);
            boolean guessedCorrectly = false;
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between " + RANGE_START + " and " + RANGE_END + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number!");
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
            } else {
                roundsWon++;
            }

            System.out.println("Your score: " + roundsWon + " round(s) won.");

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing! Final score: " + roundsWon + " round(s) won.");
        scanner.close();
    }

    private static int generateRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt((end - start) + 1) + start;
    }
}
