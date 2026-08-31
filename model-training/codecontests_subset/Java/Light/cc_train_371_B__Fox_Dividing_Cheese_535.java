import java.util.*;
import java.lang.*;
import java.io.*;
public final class GFG {
	public static void main (String[] args) {
    	solve();
	}
	static void solve() {
	    Scanner sc = new Scanner(System.in);
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    int[] c2 = new int[2];
	    int[] c3 = new int[2];
	    int[] c5 = new int[2];
	    while(a>0 && a%2==0) {
	        a/=2;
	        c2[0]++;
	    }
	    while(b>0 && b%2==0) {
	        b/=2;
	        c2[1]++;
	    }
	    while(a>0 && a%3==0) {
	        a/=3;
	        c3[0]++;
	    }
	    while(b>0 && b%3==0) {
	        b/=3;
	        c3[1]++;
	    }
	    while(a>0 && a%5==0) {
	        a/=5;
	        c5[0]++;
	    }
	    while(b>0 && b%5==0) {
	        b/=5;
	        c5[1]++;
	    }
	    if(a!=b) {
	        System.out.println(-1);
	        return;
	    }
	    System.out.println(Math.abs(c2[0]-c2[1])+Math.abs(c3[0]-c3[1])+Math.abs(c5[0]-c5[1]));
	}
}