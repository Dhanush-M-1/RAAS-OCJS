import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class A {
	public static void main(String[] args) throws Exception{
		String s = readString();
		int balance = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int lowest = 0;
		for(int i = 0; i< s.length(); i++){
			if(s.charAt(i) == '('){
				balance++;
			}
			if(s.charAt(i) == ')'){
				balance--;
			}
			if(s.charAt(i) == '#'){
				balance--;
				lowest = balance;
				ans.add(balance);
			}
			if(balance < 0){
				System.out.println(-1);
				return;
			}
			lowest = Math.min(lowest, balance);
			
		}
		if(balance > ans.get(ans.size()-1) || lowest < balance){
			System.out.println(-1);
			return;
		}
		for(int i = 0; i < ans.size(); i++){
			if(i != ans.size()-1){
				System.out.println(1);
			}
			else{
				System.out.println(balance+1);
			}
		}
		
	}
	
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer(" ");
	static String readString() throws Exception{
		while(!st.hasMoreTokens()){
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
	static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
}
