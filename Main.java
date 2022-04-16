import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        while(!game.gameOver()){
            System.out.println("\n" + game);
            System.out.println(game.getPlayer() + "\nInput where you want to go. (1 - 9)");

            int user = scan.nextInt() - 1;

            game.play((int) (user / 3), user % 3);
        }
        System.out.print(game);
      }
}
