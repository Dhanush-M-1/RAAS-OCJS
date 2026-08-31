import java.util.Scanner;

public class Solution{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int numGames = scanner.nextInt();
    scanner.nextLine();
    int player1 = 1;
    int player2 = 2;
    int spectator = 3;
    int[] winner = new int[numGames];
    int helper = -1;
    boolean error = false;
    for(int i = 0; i < numGames; i++){
    	winner[i] = scanner.nextInt();
    	scanner.nextLine();
    }
    
    for(int i = 0; i < numGames; i++){
        if(spectator == winner[i]){
            error = true;
            break;
        }

        if(winner[i] == player1){
            helper = player2;
            player2 = spectator;
            spectator = helper;
        }
        else if(winner[i] == player2){
            helper = player1;
            player1 = spectator;
            spectator = helper;
        }
        else{
          error=true;
          break;
        }
      }  
      if(!error)
    	 System.out.println("YES");
      else
        System.out.println("NO");

  }
}