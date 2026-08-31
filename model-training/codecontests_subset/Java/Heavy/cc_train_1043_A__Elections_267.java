import java.util.Scanner;

import java.util.*;
import static java.lang.Math.*; 
import static java.util.Arrays.*;

import java.io.FileInputStream;

import static java.lang.Character.*;
import static java.lang.Double.*;

public class A {
	
	private Scanner scan=new Scanner(System.in);
	
	void solve() {
		int n = scan.nextInt();
		int ma =0;
		int sum = 0;
		for(int i=0;i<n;i++) {
			int x = scan.nextInt();
			sum+=x;
			ma = max(ma,x);
		}
		for(int res=ma;;res++) {
			int sb = n*res;
			if (sb>2*sum) {
				System.out.println(res);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		A me = new A();
		try{
			Class.forName("SlexTemplate");
			String sample = me.getClass().getName()+".in";
			me.scan = new Scanner(new FileInputStream(sample));
		}catch (Exception e) {
		}
		me.solve();
	}
}
