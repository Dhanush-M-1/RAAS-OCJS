import java.util.*;
import java.lang.*;

public class Main{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] markSample = {'S', 'H', 'C', 'D'};
        char[] mark = new char[n];
        int[] number = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            mark[i] = sc.next().charAt(0);
            number[i] = sc.nextInt();
        }
        
        
        for (int i = 0; i < 52; i++) {
            char m = markSample[i / 13];
            int num = i % 13 + 1;
            for (int j = 0; j < n; j++) {
                if (number[j] == num && mark[j] == m) {
                    break;
                }
                if (j == n - 1) {
                    System.out.println(m + " " + num);
                }
            }
            
        }
    }
}

