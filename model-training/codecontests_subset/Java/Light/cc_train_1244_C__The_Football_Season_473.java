/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author kira
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        long n, p, w, d;
        n = in.nextLong();
        p = in.nextLong();
        w = in.nextLong();
        d = in.nextLong();
        for (long y = 0, x = 0; y < 1e5 + 10; y++) {
            if ((p - d * y) % w == 0) {
                x = (p - d * y) / w;
            }
            if (x + y <= n&&(x*w+y*d==p)&&x>=0) {
                System.out.println(x + " " + y + " " + (n - x - y));
                System.exit(0);
            }
        }
        System.out.println("-1");
    }

}
