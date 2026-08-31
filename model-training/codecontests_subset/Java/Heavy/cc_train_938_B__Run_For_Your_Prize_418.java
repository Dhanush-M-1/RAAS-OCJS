
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class RunForYourPrize {
    public static final int amigo = (int) 1e6;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        boolean run = true;
        int res = -1;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr = scn.nextInt();
            if (curr <= (amigo / 2)) {
                res = curr - 1;
            } else {
                res = Math.max(res, amigo - curr);
                break;
            }
        }

        System.out.println(res);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }
}