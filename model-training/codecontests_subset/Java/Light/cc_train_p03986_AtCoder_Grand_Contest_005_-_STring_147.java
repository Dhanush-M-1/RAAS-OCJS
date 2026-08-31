import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner sc;
	
	

	public static void main(String[] args) {
		
		String x;
		sc = new Scanner(System.in);
		

		x = sc.next();
		long n = x.length();
		char[] X = x.toCharArray();

		
		Stack<Character> S = new Stack<>();
		
		for(int i=0; i<n; i++){
			if(X[i]=='S'){
				S.push(X[i]);
			} else if(X[i]=='T' && S.isEmpty()){
				S.push(X[i]);
			} else if (X[i]=='T' && S.peek()=='S'){
				S.pop();
			} else {
				S.push(X[i]);
			}
		}
		
		System.out.println(S.size());

	}

}
