import java.util.*;
import java.lang.*;

public class C282 {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		char[] data = scan.nextLine().toCharArray();
		
		int total = 0;
		int pound = 0;
		int possible = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == '#') {
				pound++;
				possible--;
			}
			if (data[i] == '(') {
				total++;
				possible++;
			}
			if (data[i] == ')') {
				total--;
				possible--;
			}
		} 
		
		if (possible < 0) {
			System.out.println(-1);
			return;
		}
		
		if (data.length == 1) {
			System.out.println(-1);
			return;
		}
		
		if (total < 0) {
			System.out.println(-1);
			return;
		}
		
		ArrayList <Integer> answer = new ArrayList<Integer>();
		int left = 0;
		int right = 0;
		int print = 1;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == '#') {
				print = 1;
				if (total == 0) {
					print = 0;
				}
				
				if (pound == 1) {
					print = total;
				}
				if (right + print > left) {
					System.out.println(-1);
					return;
				}
				answer.add(print);
				pound--; total--; right += print;
			}
			if (data[i] == '(') {
				left++;
			}
			if (data[i] == ')') {
				right++;
			}
			
			if (right > left) {
				System.out.println(-1);
				return;
			}
		}
		
		for (Integer x: answer) {
			System.out.println(x);
		}
	}
}
