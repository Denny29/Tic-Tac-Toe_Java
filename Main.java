import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        char cont = 'y';

        while(cont == 'y' || cont == 'Y'){
            System.out.println("\n" + game);
            System.out.println(game.getPlayer() + "\nInput where you want to go. (1 - 9)");

            int user = scan.nextInt() - 1;

            game.play((int) (user / 3), user % 3);

            if(game.gameOver()){
                System.out.println(game);
                System.out.println("Play again? (y / n)");
                cont = scan.next().charAt(0);
                if(cont == 'y' || cont == 'Y'){
                    game = new TicTacToe();
                    //Clears screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                }
            }
        }
        
      }
}
