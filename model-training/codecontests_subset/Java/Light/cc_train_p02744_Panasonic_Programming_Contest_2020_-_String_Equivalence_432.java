
import java.util.Scanner;

public class Main{
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.next());
		
		sb.append('a');
		
		dfs(1,'1',n);
		
		

	}
	
	static void dfs(int cnt,int now ,int n) {
		
		if(sb.length() == n) {
			System.out.println(sb.toString());
			return;
		}
		boolean flag = false;
		
		for(char i = 'a' ; i <= 'a' + now - '0' ;i++)  {
			if(i == 'a' + now - '0') {
				now++;
				flag = true;
			}
			sb.append(i);
			dfs(cnt ,now , n);
			if(flag) {
				now--;
			}
			sb.deleteCharAt(sb.length()-1);
			
		}
		
	}

}
