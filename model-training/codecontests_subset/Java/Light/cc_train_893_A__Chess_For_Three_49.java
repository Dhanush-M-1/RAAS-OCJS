import java.io.*;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;
import java.math.*;
public class Educa
{
    public static void main(String[] args)throws IOException 
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		int c=0,d=0;
		for (int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			if(a==1 && i==0)
			{
				c=2;
			}
			else if(a==2 && i==0)
			{
				c=1;
			}
			else if(i==0)
			{
				d=1;
			}
			if(i>0 && c==2)
			{
				if(a==2)
				{
					d=1;
				}
				else
				{
					if(a==1)
						c=3;
					else
						c=1;
				}
			}
			else if(i>0 && c==1)
			{
				if(a==1)
				{
					d=1;
				}
				else
				{
					if(a==2)
						c=3;
					else
						c=2;
				}
			}
			else if(i>0 && c==3)
			{
				if(a==3)
				{
					d=1;
				}
				else
				{
					if(a==1)
						c=2;
					else
						c=1;
				}
			}
		}
		if(d==1)
			System.out.print("NO");
		else
			System.out.print("YES");
	}
}