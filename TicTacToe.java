public class TicTacToe {

  private static char[][] board;
  private static char player;

  public TicTacToe(){
    board = new char[][] {{'-','-','-'},
                          {'-','-','-'},
                          {'-','-','-'}};
    player = 'X';
  }
  
  private static void updatePlayer(){
    if(player == 'X')
      player = 'Y';
    else
      player = 'X';
  }
  public static String getPlayer(){
    return player + "'s turn.";
  }

  public static void play(int row, int column){
    //Checks if numbers are in range
    if((row >= 0 && row <= 2) && (column >= 0 && column <= 2)){
      //Checks if space is taken
      if(board[row][column] == '-'){
        board[row][column] = player;
        updatePlayer();
      }
      else
        System.out.println("That space is taken.");
    }
    else
      System.out.println("Please enter a number in range.");
  }
  
  public static boolean gameOver(){
    boolean out = false;
    //Horizontal win
    for(char[] row: board){
      if(row[0] != '-' && (row[0] == row[1]) && (row[1] == row[2])){
        out = true;
        System.out.println("Nice horizontal win");
        break;
      }
    }
    //Vertical win
    if(!out){
      for(int i = 0; i < 3; i++){
        if(board[0][i] != '-' && (board[0][i] == board[1][i]) && (board[1][i] == board[2][i])){
          out = true;
          System.out.println("Nice vertical win");
          break;
        }
      }
    }
    //Diagonal win
    if(!out){
      if(board[0][0] != '-' && (board[0][0] == board[1][1]) && (board[1][1] == board[2][2])){
        out = true;
        System.out.println("Nice diagonal win");
      }
      else if(board[0][2] != '-' && (board[0][2] == board[1][1]) && (board[1][1] == board[2][0])){
        out = true;
        System.out.println("Nice diagonal win");
      }
    }
    //No spaces left
    if(!out){
      boolean flag = true;
      for(char[] row: board){ 
        for(char c: row){
          if(c == '-'){
            flag = false;
            break;
          }
        }
      }
      if(flag){
        out = true;
        System.out.println("Nice Draw.");
      }
    }
    return out;
  }

  public String toString(){
    String out = "";
    for(char[] row: board){ 
      for(char c: row){
        out+=c + " ";
      }
      out+="\n";
    }
    return out;
  }
  
}
