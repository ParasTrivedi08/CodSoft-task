    import java.util.Scanner;
    import java.util.Random;
    public class Codsoft_1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int minRange = 1;
            int maxRange = 100;
            int attemptsLimit = 5;
            int score = 0;
    
            System.out.println("Welcome to the Number Guessing Game!");
    
            do {
                int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                System.out.println("\nI've selected a number between " + minRange + " and " + maxRange + ". Guess it!");
    
                for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
                    System.out.print("Attempt " + attempts + ": ");
                    int userGuess = scanner.nextInt();
    
                    if (userGuess == randomNumber) {
                        System.out.println("Congratulations! You guessed the number correctly.");
                        score++;
                        break;
                    } else if (userGuess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
    
                    if (attempts == attemptsLimit) {
                        System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
                    }
                }
    
                System.out.print("\nDo you want to play again? (yes/no): ");
            } while (scanner.next().equalsIgnoreCase("yes"));
    
            System.out.println("Game over. Your score is: " + score);
        }
    }
