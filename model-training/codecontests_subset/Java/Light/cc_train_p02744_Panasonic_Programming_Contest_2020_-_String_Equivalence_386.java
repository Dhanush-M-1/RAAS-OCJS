import java.util.*;
import java.math.*;

public class Main {
	public static int n;
	public static void main(String ards[])
	{
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		dfs(0, "");
	}
	
	public static void dfs(int c, String str){
		if(str.length() == n){
			System.out.println(str);
			return;
		}
 
		for(char i = 0; i < c + 1; i++){
			String str2 = str + String.valueOf((char)('a' + i));
			dfs(Math.max(c, i+1), str2);
		}
	}
}