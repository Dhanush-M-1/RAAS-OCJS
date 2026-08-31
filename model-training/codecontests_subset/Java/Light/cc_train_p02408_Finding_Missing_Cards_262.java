import java.io.*;
import java.util.*;

class Main {
    public static void main(String [] args){
        Scanner scan      = new Scanner(System.in);
        String mark       = "SHCD";
        boolean [][] card = new boolean[4][13];
        
        int n = scan.nextInt();
        
        for(int i = 0; i < n; ++i){
            char c = scan.next().charAt(0);
            int  t = scan.nextInt();
            
            card[mark.indexOf(c)][t - 1] = true;
        }
        
        for(int i = 0; i < 4; ++i){
            for(int j = 0; j < 13; ++j){
                if(!card[i][j]){
                    System.out.println(mark.charAt(i) + " " + (j + 1));
                }
            }
        }
    }
}
