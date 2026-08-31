import java.util.*;
import java.io.*;
public class Solution {

	static Scanner scr=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int t=scr.nextInt();
//		while(t-->0) {
			solve();
			System.out.println();
//		}
	}
	static void solve() {
		String a=scr.next();
		String b=scr.next();
		int n=scr.nextInt();
		System.out.println(a+" "+b);
		for(int i=0;i<n;i++) {
			String c=scr.next();
			String d=scr.next();
			if(a.equals(c)) {
				a=d;
			}else {
				b=d;
			}
			System.out.print(a+" "+b);
			System.out.println();
		}
	}
}