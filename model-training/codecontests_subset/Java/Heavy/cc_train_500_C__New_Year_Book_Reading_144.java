// package Div2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Sketch {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); int m = input.nextInt();
		int[] W = new int[n]; int[] B = new int[m];
		for(int i=0; i<n; i++) W[i] = input.nextInt();
		for(int i=0; i<m; i++) B[i] = input.nextInt()-1;
		input.close();
		
		int total = 0;
		boolean[] prev = new boolean[n];
		for(int i=0; i<n; i++){
			int start = m-1;
			for(int j=0; j<m; j++){
				if(B[j] == i) {start = j; break;}
			}
			for(int j=start+1; j<m; j++){
				if(B[j] != i){
					if(!prev[B[j]]){
						prev[B[j]] = true;
						total += W[i];
					}
				}
				else 
					for(int k=0; k<n; k++) prev[k] = false;
			}
			for(int k=0; k<n; k++) prev[k] = false;
		}
		
		System.out.println(total);
	}
}