import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n-1;i++)
		{
		    int x=sc.nextInt();
		    int y=sc.nextInt();
		    arr[x-1]++;
		    arr[y-1]++;
		}
		int ans=0;
		for(int i=0;i<n;i++)
		    if(arr[i]==2)
		    ans=-1;
		if(ans==-1)
		System.out.println("NO");
		else
		System.out.println("YES");
	}
}
