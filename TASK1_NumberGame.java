import java.util.Random;
import java.util.Scanner;

public class TASK1_NumberGame {

    public static void main(String[] args) {


        int MiniRange = 1;
        int MaxiRange = 100;
        int MaxiAttempts = 7;

        NumberGame(MaxiRange,MiniRange,MaxiAttempts);

    }

    private static void NumberGame(int MaxiRange, int MiniRange, int MaxiAttempts) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int Totalscore = 0;

        System.out.println("Welcome to the Number Guessing Game!\n");
        boolean Play_Again = true;

        while (Play_Again) {
            int target = random.nextInt(MaxiRange - MiniRange + 1) +MiniRange;
            System.out.println("Round - Range: "+ MiniRange + " to "+ MaxiRange);
            System.out.println("You have " + MaxiAttempts + " attempt\n");

            int Attempts = 0;
            boolean guessed = false;

            while (Attempts < MaxiAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();

                Attempts++;

                if (userGuess == target) {
                    System.out.printf("Correct! You guessed the number in %d attempts.\n", Attempts);
                    Totalscore += Attempts;
                    guessed = true;
                    break;
                } else if (userGuess < target) {
                    System.out.println("Too low! Try again.\n");
                } else {
                    System.out.println("Too high! Try again.\n");
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + target);
            }

            System.out.println("Your current score: " + Totalscore );

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainResponse = sc.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                Play_Again = false;
            }
        }

        System.out.println("Thank you for playing! Your final score: " + Totalscore);

        sc.close();
    }
}