//package c102;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);        
        int r1 = in.nextInt(),r2 = in.nextInt(),c1 = in.nextInt(),c2 = in.nextInt(),
            d1 = in.nextInt(),d2 = in.nextInt();
        int a1,a2,b1,b2;
        for (a1 = 1; a1 < 10; a1++) {
            for (a2 = 1; a2 < 10; a2++) {
                if (a2 == a1 || a1+a2!=r1) continue;
                for (b1 = 1; b1 < 10; b1++) {
                    if (b1 == a1 || b1 == a2 || a1+b1!=c1 || b1+a2!=d2) continue;
                    for (b2 = 1; b2 < 10; b2++) {
                        if (b2 == b1 || b2 == a1 || b2 == a2 || b1+b2!=r2
                                || b2 + a2!=c2 || a1+b2!=d1) continue;
                        // ura
                        System.out.print("" + a1 + " " + a2 + "\n" + b1 + " " + b2);                        
                        return ;
                    }
                }
            }
        }
        System.out.print(-1);
    }
}
