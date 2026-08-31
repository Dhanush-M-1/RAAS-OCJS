import java.util.*;
 
class Main{
	public static void main(String[] a){
		String X;
		Scanner in = new Scanner(System.in);
		X = in.next();
		Stack<Character> s = new Stack<Character>();
		for(int i=0; i<X.length(); i++){
			if(s.empty()){
				s.push(X.charAt(i));
				continue;
			}
			if((s.peek()=='S') && (X.charAt(i)=='T')) s.pop();
			else s.push(X.charAt(i));
		}
		StringBuilder sb = new StringBuilder("");
		while(!s.empty()){
			sb.append(s.pop());
		}
		System.out.println(sb.length());
	}
}