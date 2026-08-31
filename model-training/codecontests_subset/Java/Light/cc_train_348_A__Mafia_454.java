import java.util.*;

public class Main { 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int numPlayers = sc.nextInt();
        double numPlays = 0;
        long maxInput = 0;
        for (int i = 0; i < numPlayers; i++) {
            long input = sc.nextLong();
            maxInput = Math.max(maxInput, input);
            numPlays += (double)input / (double)(numPlayers-1);
        }
        
        System.out.println(Math.max(maxInput, (long)Math.ceil(numPlays))+"");
    }
}