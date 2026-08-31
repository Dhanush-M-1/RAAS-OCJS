import java.util.HashMap;
import java.util.Scanner;


/***
 * 
 * Problem: 			Codeforces 545C
 * URL:					http://codeforces.com/problemset/problem/545/C
 * Category: 			DP, Greedy
 * 
 * Author: 				biffster
 * Date Started: 		10/31/2017
 * Date Last Modified: 	11/1/2017
 * Date Completed:		N/A
 *
 */
public class Woodcutters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), total = 0, leftVal;
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		int[] locations = new int[n];
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt(), h = sc.nextInt();
			m.put(x, h);
			locations[i] = x;
		}
		
		total++;															// First tree always falls left
		leftVal = locations[0];
		for (int i = 1; i < n - 1; i++) {									// Start at the second tree
			if ((locations[i] - m.get(locations[i])) >
					leftVal) {												// The tree can fall to the left
				total++;
				leftVal = locations[i];
				
			} else if ((locations[i] + m.get(locations[i])) <
					locations[i + 1]) {										// Tree can fall to the right
				total++;
				m.put(locations[i] + m.get(locations[i]), 0);
				leftVal = locations[i] + m.get(locations[i]);
				
			} else {
				leftVal = locations[i];
			}
		}
		
		total++;															// Last tree always falls right
		
		if (n > 1)
			System.out.println(total);										// Use the answer calculated above
		else																// Answer calculated will be 2, but correct answer is 1 since there is only 1 tree
			System.out.println(1);
		
		sc.close();
	}

}
