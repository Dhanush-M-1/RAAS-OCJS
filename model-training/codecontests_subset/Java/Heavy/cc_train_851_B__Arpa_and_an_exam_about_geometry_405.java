/*
ID: andrew42
LANG: JAVA
TASK: 
PROG: 
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class arpageo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long ax = input.nextLong(); long ay = input.nextLong(); long bx = input.nextLong(); long by = input.nextLong(); long cx = input.nextLong(); long cy = input.nextLong();
		long numer = cy-by; long denom = cx-bx;
		long num = numer; long den = denom;
		boolean line = false;
		if (den == 0 || num == 0){
			if (den == 0){
				line = ax == bx;
			} else {
				line = ay == by;
			}
		} else {
			while (num%den != 0){
				long n = den;
				den = num%den;
				num = n;
			}
			numer /= den; denom /= den;
			line = -numer*ax+denom*ay == -numer*bx + denom*by;
		}
		System.out.println((bx-ax)*(bx-ax)+(by-ay)*(by-ay) == (bx-cx)*(bx-cx)+(by-cy)*(by-cy) && !line ? "Yes" : "No");
	}
}
