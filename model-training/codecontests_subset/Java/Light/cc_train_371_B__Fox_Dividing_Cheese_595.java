/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int[] aa, bb;
        aa = new int[6];
        bb = new int[6];
        int[] primes = {2, 3, 5};
        for(int i: primes) {
            while(a%i == 0) { a /= i; aa[i]++;}
            while(b%i == 0) { b /= i; bb[i]++;}
        }
        if(a != b) System.out.println(-1);
        else System.out.println(Math.abs(aa[2] - bb[2]) + Math.abs(aa[3] - bb[3]) + Math.abs(aa[5] - bb[5]));
    }
}