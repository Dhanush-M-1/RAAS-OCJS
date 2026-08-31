import java.util.*;
import java.io.*;
import java.lang.*;
public class Sol {
	public static void main(String[] args)throws IOException
	{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n,i,j,a=0,b=0;
		n=Integer.parseInt(input.readLine());
		String s[]=input.readLine().split(" ");
		for(i=0;i<n;i++)
		{
		    j=Integer.parseInt(s[i]);
		    if(j==100)
		    a++;
		    else
		    b++;
		}boolean ans=false;
		if(a%2==0)
		{
		    if((b%2!=0&&a>0)||b%2==0)
		    ans=true;
		}
		if(ans)
		System.out.println("YES");
		else
		System.out.println("NO");
		}
}