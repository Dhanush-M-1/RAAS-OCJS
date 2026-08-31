import java.util.*;
public class CF433A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int n = in.nextInt();
		for(int i = 0; i < n; i ++)
		{
			if(in.nextInt()==100)b++;
			else a++;
		}
		boolean ans = false;
		if(a%2==0&&b%2==0)
			ans = true;
		if(a%2!=0&&b%2==0 &&b!=0)
			ans = true;
		System.out.println(ans?"YES":"NO");
	}
}
