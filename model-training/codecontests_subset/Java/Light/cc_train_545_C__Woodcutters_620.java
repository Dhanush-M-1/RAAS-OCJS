import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int n=sc.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			for(int i=0;i<n;i++) {
				a[i]=sc.nextInt();
				b[i]=sc.nextInt();
			}
			int s=2;
			for(int i=1;i<n-1;i++)
			{
				if(a[i]-a[i-1]>b[i])
				{
					s++;
				}
				else if(a[i+1]-a[i]>b[i])
				{
					s++;
					a[i]+=b[i];
				}
			}
			System.out.println(n==1?1:s);
	}
}