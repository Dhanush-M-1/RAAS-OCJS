
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);
        String mark = "SHCD";
        boolean[][] cards = new boolean[4][13];

        int n = scan.nextInt();
        for(int i = 0; i < n; i++){
            char c = scan.next().charAt(0);
            int num = scan.nextInt();

            cards[mark.indexOf(c)][num-1] = true;
 
        }

        for(int t = 0; t < 4; t++){
            for(int f = 0; f < 13; f++){
                if(cards[t][f] == false){
                    System.out.println(mark.charAt(t) + " " + (f+1));

                }
            }
        }

    }
}

