//package cf3;

import java.util.*;
import java.io.*;

public class Q2A {

	// main method
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int h=0,t=0;
		for(int i=0;i<n;i++){
			int temp=sc.nextInt();
			if(temp==100)
				h++;
			else
				t++;
				
		}
		if(h%2==0 && t%2==0){
			System.out.println("YES");
		}else if(h%2!=0 && t%2==0){
			System.out.println("NO");
		}else if(h%2==0 && t%2!=0){
			if(h>0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}else{
				System.out.println("NO");
		}
		// end of main
	}

}
