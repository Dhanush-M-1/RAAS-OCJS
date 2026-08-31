/* Filename: AGC005A.java
 * Author: Mushiyo
 */

import java.util.Scanner;
import java.util.Stack;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			String X = input.next();
			Stack<Character> stack = new Stack<Character>();
			
			for(int i = 0; i < X.length(); ++i){
				if(stack.empty() == false){
					if(stack.peek() == 'S' && X.charAt(i) == 'T'){
						stack.pop();
					} else {
						stack.push(X.charAt(i));
					}
				} else {
					stack.push(X.charAt(i));
				}
			}
			
			System.out.println(stack.size());
		}
	}

}
