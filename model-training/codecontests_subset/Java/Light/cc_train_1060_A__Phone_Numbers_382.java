import java.util.*;

public class helloWorld 
{
	static ArrayList<Integer> ar;
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String str = in.next();
		int m = 0, ans = 0;
		
		for(int i = 0; i < str.length(); i++)
			if(str.charAt(i) == '8')
				m++;
		
		ans = Math.min(m, n/11);
		
		System.out.println(ans);
		
		in.close();
	}
}