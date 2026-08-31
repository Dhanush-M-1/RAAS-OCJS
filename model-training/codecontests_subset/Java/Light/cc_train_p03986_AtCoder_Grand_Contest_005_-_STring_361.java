

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		Stack<Character> stack = new Stack<Character>();

		int pair = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);

			if(!stack.isEmpty() && c == 'T'){
				stack.pop();
				pair++;
			}
			else if(c == 'S'){
				stack.push(c);
			}
		}

		System.out.println(str.length() - pair*2);
	}

}
