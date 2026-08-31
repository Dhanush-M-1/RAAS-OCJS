import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a[] = new int[21];
		int b[] = new int[21];
		int c[] = new int[21];

		for(int i = 1 ; i <= n ; i++){
			a[i] = sc.nextInt();
		}
		for(int i = 1 ; i <= n ; i++){
			b[i] = sc.nextInt();
		}
		for(int i = 1 ; i < n ; i++){
			c[i] = sc.nextInt();
		}

		int ans = 0;
		ans += b[a[1]];
		int pre = a[1];
		for(int i = 2 ; i <= n ; i++){
			ans += b[a[i]];
			if(a[i] == pre+1){
				ans += c[pre];
			}
			pre = a[i];
		}
		if(a[n] == pre+1){
			ans += c[pre];
		}

		System.out.println(ans);
	}
}