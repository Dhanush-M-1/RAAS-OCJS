import java.util.*;
import java.io.*;
public class Codeforces {
	
	static void sort(int[] ar) {
		ArrayList<Integer> al=new ArrayList<>();
		for (int i=0;i<ar.length;i++) al.add(ar[i]);
		Collections.sort(al);
		for (int i=0; i<ar.length; i++) ar[i]=al.get(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 PrintWriter writer = new PrintWriter(System.out); 
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			char a[]=sc.next().toCharArray();
			
			int p[]=new int[n];
			for(int i=0;i<m;i++)
				p[sc.nextInt()-1]++;
			
			int c[]=new int[26];
			for(int i=n-1;i>0;i--)
			{
				p[i-1]+=p[i];
			}
			for(int i=0;i<n;i++)
			{
				c[a[i]-'a']+=p[i]+1;
			}
			for(int i=0;i<26;i++)
				System.out.print(c[i]+" ");
			System.out.println();
		}
writer.flush();
	}

}