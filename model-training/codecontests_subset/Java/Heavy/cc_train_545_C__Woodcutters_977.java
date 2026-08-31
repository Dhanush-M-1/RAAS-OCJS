//package CProblems;

import java.util.Scanner;

public class WoodCutters {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(), nbTrees = 0;
		long x[] = new long[n];
		long h[] = new long[n];
		for(int i = 0; i < n; i++) {
			x[i] = input.nextLong();
			h[i] = input.nextLong();
		}
		for(int i = 0; i < n; i++) {
			if(i == 0 || i == n - 1)
				nbTrees++; // of course I can cut it to the left or to the right (no trees occupied)
			else if (i > 0 && i < n-1) {
				// check if I can cut it to the left
				if(x[i] - h[i] > x[i-1])//not occupied to the left
					nbTrees++;
				else {
					// try right
					if (x[i] + h[i] < x[i+1]) { //not occupied to the right
						nbTrees++;
						x[i] = x[i] + h[i]; //update it, since the next time I will check it
					}
				}
				
			}
		}
		System.out.println(nbTrees);
	}
}
