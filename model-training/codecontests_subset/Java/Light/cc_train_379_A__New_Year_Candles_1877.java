//package solution;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int res = 0;
		int newCandle = a;
		int usedCandle = 0;
		
		while(newCandle > 0) {
			res += newCandle;
			usedCandle += newCandle;
			
			newCandle = usedCandle / b;
			usedCandle -= newCandle * b;
		}
		
		System.out.println(res);
	}

}
