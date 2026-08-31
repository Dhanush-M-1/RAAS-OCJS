import java.util.*;
public class CF0268A {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] h=new int[n];
		int[] a=new int[n];
		int count=0;
		for(int i=0;i<n;i++)
		{
			h[i]=in.nextInt();
			a[i]=in.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==j) {continue;}
				if(h[i]==a[j]){count++;}
			}
		}
		System.out.println(count);
	}
}