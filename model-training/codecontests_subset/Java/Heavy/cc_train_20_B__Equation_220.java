/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class Main {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    double a = sc.nextInt(), b =sc.nextInt(), c = sc.nextInt();
	    double r= b*b - 4*a*c;
	    if(a==0 && b==0 && c==0){
	        System.out.println(-1); return;
	    }
	    if(a==0 && b==0){
	        System.out.println(0); return;
	    }
	    if(a==0){
	        System.out.println(1); System.out.println(-1*c/b); return;
	    }
	    double rr = Math.sqrt(r);
	    if(r>0){
	        System.out.println(2);
	        double d1 = ((-1*b)+rr)/(2*a), d2 = ((-1*b)-rr)/(2*a);
	        if(d1<d2){
	            System.out.println(d1+"\n"+d2); return;
	        } else System.out.println(d2+"\n"+d1); return;
	    }
	    if(r==0){
	        System.out.println(1);
	        System.out.println(-1*b/(2*a));
	    }
	    if(r<0){
	        System.out.println(0);
	    }
	}
}