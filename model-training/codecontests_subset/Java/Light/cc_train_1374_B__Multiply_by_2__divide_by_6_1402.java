import java.util.*;
import java.io.*;

public class Mul2div6 {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        
        for(int i=0; i<t; i++) {
            int n = scan.nextInt();
            int count2 = 0;
            while(n%2==0){
                n = n/2;
                count2++;
            }
            int count3 = 0;
            while(n%3==0) {
                n = n/3;
                count3++;
            }
            if(n!=1) {
                System.out.println(-1);
            }
            else{
                if(count2==count3){
                    System.out.println(count3);
                }
                else if(count2>count3){
                    System.out.println(-1);
                }
                else{
                    System.out.println(count3-count2+count3);
                }
            }
        }
    }
}

            // int limit = 4*n;
            // int move = 0;
            // while(n!=1 && n<limit) {
            //     if(n%6==0) {
            //         n = n/6;
            //     }
            //     else{
            //         n = n*2;
            //     }
            //     move++;
            //     // System.out.println(n);
            // }
            // if(n>=limit) {
            //     System.out.println(-1);
            // }
            // else{
            //     System.out.println(move);
            // }