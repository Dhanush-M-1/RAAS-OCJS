import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- > 0) {
            int n = sc.nextInt();
            int count2 = 0;
            int count3 = 0;
            
            boolean possible = true;
            
            while(n>0) {
                if(n == 1) {
                    break;  
                } else if(n%2 == 0) {
                    count2++;
                    n/=2;
                } else if(n%3 == 0) {
                    count3++;
                    n/=3;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if(possible) {
                int b = count3;
                int a = b - count2;
                
                if(a <0 || b <0) {
                    System.out.println(-1);
                } else {
                    System.out.println(a+b);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}