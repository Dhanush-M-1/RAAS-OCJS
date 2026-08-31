import java.util.*;
import java.math.*;

public class Main{
	static int maxn=110;
	
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int[] a=new int[maxn];
		int n=cin.nextInt();
		int sum=0,k=-1;
		
		for(int i=1;i<=n;i++) {
			a[i]=cin.nextInt();
			sum+=a[i];
			k=Math.max(a[i], k);
		}
		int cnt=0;
		for(int i=1;i<=n;i++)
			cnt+=(k-a[i]);
		if(cnt>sum)
			System.out.println(k);
		else {
			if((sum-cnt)%n==0)
				k+=(sum-cnt)/n+1;
			else
				k+=(int)Math.ceil( (sum-cnt)/Double.valueOf(n) );
			//System.out.println(add);
			System.out.println(k);
		}
		cin.close();
	}
}