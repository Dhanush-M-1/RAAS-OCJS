import java.awt.*;
import java.awt.geom.*;
import java.io.*;

import java.util.*;
class Main {
	
	static int a;
	static int b;
	static int c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		int sumA = c;
		int sumB = a;
		double max = (double)sumA/sumB;
		
		for(int i = n-1; i >= 0; i--) {
			if((double)(sumA + list[i]) / (sumB + b) > max) {
				max = (double)(sumA + list[i]) / (sumB + b);
				sumA += list[i];
				sumB += b;
			}
			else {
				break;
			}
		}
		
		System.out.println((int)max);
		
	}
}