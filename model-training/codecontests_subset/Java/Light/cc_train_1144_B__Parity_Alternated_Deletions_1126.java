//package Codef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];;
		//int[] l = new int[n];
		//int[] r = new int[n];
		PriorityQueue<Integer> l1 = new PriorityQueue<>();
		PriorityQueue<Integer> l2 = new PriorityQueue<>();

		int co=0,ce=0;
		for(int i=0;i<n;i++) {
			a[i] = s.nextInt();
			if(a[i]%2 == 0) {
			   //ce++;
				l1.add(a[i]);
				//k++;
			}
			else { 
				//co++;
				l2.add(a[i]);
			}
		}
		//System.out.println(l2.size());
		int dif = Math.abs(l1.size()-l2.size());
		if(dif <= 1) {
			System.out.println(0);
		}else {
			PriorityQueue<Integer> l3 ;
			if(l1.size() > l2.size()) {
				l3 = l1;
			}else {
				l3 = l2;
			}
			long sum=0;
			 for(int i=0;i<dif-1;i++) {
				 //System.out.println(l3.peek());
				 sum+= l3.poll();
			 }
			 System.out.println(sum);

		}
		
	}

}
