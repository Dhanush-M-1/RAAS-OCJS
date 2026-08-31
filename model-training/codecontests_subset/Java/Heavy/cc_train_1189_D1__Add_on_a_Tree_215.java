/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

    ArrayList<Integer>[] adj=new ArrayList[n+1];
    for(int i=1;i<=n;i++)
        adj[i]=new ArrayList<>();
    for (int i = 0; i < n-1; i++)
     {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
    if(n<=2)
    {
        System.out.println("YES");
        System.exit(0);
    }
    for(int i=1;i<n+1;i++)
    {
        if(adj[i].size()==2)
        {
            System.out.println("NO");
            System.exit(0);
        }
    }
    System.out.println("YES");
	}
}