import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.*;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class x
{
    public static void main(String[] args) 
	{
        Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int a=in.nextInt();
		int b=in.nextInt();
		int c=in.nextInt();
		int d=in.nextInt();
		int i,val1,val2;
		int count=0;
		val1=0;
		val2=0;
		//System.out.println("Here1 "+(n==5));
		if(k==n-1||n==4||k==n)
		{
			//System.out.println("Here2 "+(n==5));
			System.out.println(-1);
			System.exit(0);
		}
		//System.out.println("Here "+(n==5));
		if(n==5)
		{
			//System.out.println("Here");
			int val=0;
			int h[]=new int[n+1];
			h[a]=1;
			h[b]=1;
			h[c]=1;
			h[d]=1;
			for(i=1;i<=n;i++)
			{
				if(h[i]==0)
				{
					val=i;
				}
			}
			System.out.println(a+" "+c+" "+val+" "+d+" "+b);
			System.out.println(c+" "+a+" "+val+" "+b+" "+d);
			System.exit(0);
		}
		int h[]=new int[n+1];
        int ans[]=new int[n+1];
		h[a]=1;
		h[b]=1;
		h[c]=1;
		h[d]=1;
        count=0;
		System.out.print(a+" "+c+" ");
        ans[1]=a;
        ans[2]=c;
        int index=3;
		for(i=1;i<=n;i++)
		{
			if(h[i]==0)
			{
				System.out.print(i+" ");
                count++;
                ans[index++]=i;
                if(count==1)
				{
					System.out.print(d+" ");
                    ans[index++]=d;
				}
			}
		}
        ans[index++]=b;
		System.out.println(b);
        //System.out.println(Arrays.toString(ans));
        System.out.print(ans[2]+" "+ans[1]+" "+ans[3]+" "+ans[n]+" ");
        for(i=n-1;i>3;i--)
            {
            System.out.print(ans[i]+" ");
        }
    }
}