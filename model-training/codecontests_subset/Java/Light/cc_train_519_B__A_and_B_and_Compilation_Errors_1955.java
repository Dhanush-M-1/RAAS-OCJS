

import java.util.*;

/**
 * Created by Askar on 08.06.2017.
 */


public class task1 {
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            c1 += in.nextInt();
        }
        int c2 = 0;
        for (int i = 0; i < n-1; i++) {
            c2 += in.nextInt();
        }
        int c3 = 0;
        for (int i = 0; i < n-2; i++) {
            c3 += in.nextInt();
        }
        System.out.println(c1-c2);
        System.out.println(c2-c3);
        
    }
}