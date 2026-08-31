//package CodeForces;
import java.util.*;
public class Prac_1311C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			String s=sc.next();
			//int[] p=new int[m];
			int[] cnt=new int[n];
			int[] ans=new int[26];
		
			for(int i=0;i<m;i++)
			{
				int p=sc.nextInt();
				++cnt[p-1];
			}
			for(int i=n-1;i>0;--i)
			{
				cnt[i-1]+=cnt[i];
			}
			for(int i=0;i<n;i++)
			{
				ans[s.charAt(i)-'a']+=cnt[i];
				++ans[s.charAt(i)-'a'];
			}
			
			for(int i=0;i<26;i++)
			{
				System.out.print(ans[i]+" ");
			}
			System.out.println();
		}

	}

}
