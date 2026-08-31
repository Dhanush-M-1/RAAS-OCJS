import java.util.Scanner;
import java.util.Stack;

class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.next();
			Stack<Integer> st=new Stack<Integer>();
			for(int i=0;i<str.length();i++){
				if(st.isEmpty() || st.peek()==1 || str.charAt(i)=='S') st.add(str.charAt(i)=='S' ? 0 : 1);
				else st.pop();
			}
			System.out.println(st.size());
		}
	}
}