import java.util.Scanner;


public class Mafia {
    
    public static long calcNumRounds(int[] a) {
        long sum = 0;
        long max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {max = a[i];}
            sum += a[i];
        }
        
        long rounds = max;
        while (true) {
            if (rounds * a.length >= rounds + sum) {return rounds;}
            rounds++;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int numPlayers = in.nextInt();
        int[] a = new int[numPlayers];
        
        for (int i = 0; i < numPlayers; i++) {
            a[i] = in.nextInt();
        }
        in.close();
        System.out.println(calcNumRounds(a));
    }
}