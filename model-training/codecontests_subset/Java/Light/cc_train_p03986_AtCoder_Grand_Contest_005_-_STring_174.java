import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Stack st = new Stack();
		char[] ch = s.toCharArray();
		for (int i=0;i<ch.length;i++){
			if (st.isEmpty()){
				if (ch[i]=='S'){
					st.push("S");
				}
				else{
					st.push("T");
				}
			}
			else{
				if (ch[i]=='S'){
					st.push("S");
				}
				else if (ch[i]=='T'&& st.peek()=="S"){
						st.pop();
				}
				else{
					st.push('T');
				}
			}			
		}
		System.out.println(st.size());
	}

}