
import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author btx
 */
public class a {

    static boolean[] p;

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int h = in.nextInt();
	String s = in.next();
	if (h > 4) {
	    p = new boolean[h];
	    for (int i = 0; i < h; i++) {
		if (s.charAt(i) == '*') {
		    p[i] = true;
		}
	    }

	    int x = 0;

	    do {
		x++;
		x = Math.max(1, x);
		kovip:
		for (int ip = 0; ip < h; ip++) {
//		    if (5 * x + ip < h) {
//			continue kovip;
//		    }
		    for (int l = 0; l <= 4; l++) {
			if (l * x + ip >= h) {
			    continue kovip;
			}
			if (!p[l * x + ip]) {
			    continue kovip;
			}
			if (l == 4) {
			    System.out.println("yes");
			    return;
			}
		    }
		}
	    } while (h / x >= 4);
	}
	System.out.println("no");

    }

}
