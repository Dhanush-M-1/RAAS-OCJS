

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


@SuppressWarnings("unused")
public class A {
	public  static  Scanner scan = new Scanner(System.in);
	
	public static void solve () {
		int n=scan.nextInt();
		String s=scan.next();
		int cnt=0;
		for(int i=0;i<n;i++) {
			if(s.charAt(i)=='8') {
				cnt++;
			}
		}
		System.out.println(Math.min(cnt,n/11));
		
	}
	
	public static void main(String[] args) {
	
		solve();
		scan.close();
	}

}

