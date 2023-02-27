import java.util.Scanner;

/**
* This program receives the meal from the user.
* It also gets the number of items and it
* calculates how long they should heat it up.
*
* @author Melody  Berhane
* @version 1.0
*
* @since   2023-02-22
*/

public final class DiceGame {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // declare constants
        final int MIN = 1;
        final int MAX = 6;

        // declare variables
        String userString = " ";
        int guesses = 1;
        int userInt = 0;
        int randomInt = 1;
        
        // Create a new scanner constant
        final Scanner scanner = new Scanner(System.in);
        // generate random number between min and max
        randomInt = (int) Math.floor(Math.random()
            * (MAX - MIN + 1) + MIN);
        loop: {
            while (true) {
                // Ask user for guess
                System.out.print("Guess an integer from 1 to 6: ");
                userString = scanner.nextLine();

                try {
                    // Check if guess is an integer
                    userInt = Integer.parseInt(userString);

                    // Check if guess is within range
                    if (userInt > MAX || userInt < MIN) {
                        // Error message if guess isn't within range
                        System.out.println("Must be between 1 and 6,"
                            + " try again.");
                    } else {
                        while (true) {
                            // Check if guess is the same
                            // as the generated number
                            if (userInt == randomInt) {
                                if (guesses == 1) {
                                    // Congratulation message if
                                    // user guessed only once
                                    System.out.println("You guessed correctly!"
                                        + " It took you " + guesses + " try!");
                                    break loop;
                                } else {
                                    // Congratulation message if
                                    // user guessed more than once
                                    System.out.println("You guessed correctly"
                                        + "! It took you " + guesses
                                        + " tries!");
                                    break loop;
                                }
                            } else if (userInt < randomInt) {
                                // Outputted message if guess is
                                // lower than generated number
                                System.out.println("The number is higher.");
                                // Increase guess value by 1
                                guesses++;
                                break;
                            } else {
                                // Outputted message if guess is higher
                                // than generated number
                                System.out.println("The number is lower.");
                                // Increase guess value by 1
                                guesses++;
                                break;
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    // Error message if guess isn't an integer
                    System.out.print("Please enter a valid integer.\n");
                }
            }
        }
        scanner.close();
    }
}
