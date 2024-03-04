import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        // Loop until the user decides not to play again
        do {
            // Prompt player A and player B to enter their moves
            System.out.println("Enter your move (R for Rock, P for Paper, S for Scissors):");
            String playerA = getPlayerMove(scanner);
            String playerB = getPlayerMove(scanner);

            // Determine the winner and display the result
            String result = determineWinner(playerA, playerB);
            System.out.println(result);

            // Prompt the user to play again
            System.out.println("Do you want to play again? (Y/N)");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));

        scanner.close();
    }

    // Method to get a valid move from the player
    private static String getPlayerMove(Scanner scanner) {
        String move;
        do {
            move = scanner.nextLine().toUpperCase();
            // Check if the move is valid
            if (!move.equals("R") && !move.equals("P") && !move.equals("S")) {
                System.out.println("Invalid move! Please enter R, P, or S.");
            }
        } while (!move.equals("R") && !move.equals("P") && !move.equals("S"));
        return move;
    }

    // Method to determine the winner based on the moves
    private static String determineWinner(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            return "It's a tie!";
        } else if (playerA.equals("R") && playerB.equals("S") ||
                playerA.equals("P") && playerB.equals("R") ||
                playerA.equals("S") && playerB.equals("P")) {
            return "Player A wins!";
        } else {
            return "Player B wins!";
        }
    }
}
