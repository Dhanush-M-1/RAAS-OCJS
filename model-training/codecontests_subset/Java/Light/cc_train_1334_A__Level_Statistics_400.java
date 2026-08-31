import java.util.*;
import java.io.*;

public class MyClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            int previousPlay = 0, previousClear = 0;
            String ans = "yes";
            while(n-- > 0){
                int play = sc.nextInt();
                int clear = sc.nextInt();
                int diffClear = clear - previousClear;
                int diffPlay = play - previousPlay;
                if(diffClear < 0 || diffPlay < 0 || diffClear > diffPlay){
                    ans = "no";
                }
                previousPlay = play;
                previousClear = clear;
            }
            
            System.out.println(ans);
        }
        
      
    }
}