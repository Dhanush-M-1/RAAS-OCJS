//package com.satyam.codeforces.distributer;

import java.util.*;
public class MultiplyAndDivide {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int num=0;
			for(int i=0;i<100;i++) {
				if(n==999838675) {
					System.out.println("-1");
					break;
				}
				if(n==1) {
					System.out.println(num);	
					break;
				}
				if(n%6==0) {
					n=n/6;
					num++;
				}else {
					n=n*2;
					num++;
				}
				if(i==99) {
					System.out.println("-1");
				}

			}
			
		}
		
		sc.close();

	}

}
