import java.util.*;

public class helloWorld 
{
	static int n;
	static Pair[] dn;
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String str = in.next();
		dn = new Pair[n+1];

		for(int i = 0; i <= n; i++)
			dn[i] = new Pair(0, 0);
		
		Pair ans = f(0, str);
		
		System.out.println(ans.x);
		for(int i = 0; i != n; i = dn[i].y)
			System.out.printf("%s ", str.substring(i, dn[i].y));
		System.out.println();
		
		in.close();
	}
	public static Pair f(int a, String str)
	{
		if(a == str.length())
			return new Pair(0, a);
		if(dn[a].x != 0)
			return dn[a];
		int cnt = 0;
		Pair ans = new Pair(1000, 0);
		for(int i = a; i < str.length(); i++) {	
			if(str.charAt(i) == '1')
				cnt++;
			if(2*cnt != i-a+1) {
				Pair p = f(i+1, str);
				if(p.x + 1 < ans.x) {
					ans.x = p.x+1;
					ans.y = i+1;
				}
			}
		}
		if(2*cnt != str.length() - a)
			ans = new Pair(1, str.length());
		return dn[a] = ans;
	}
}
class Pair 
{
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
