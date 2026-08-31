

import java.util.*;
import java.lang.*;
import java.io.*;

public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		int cnt=0;
		for(int i=0;i<=c;i++)
		{
		    for (int j=0;j<=b;j++)
		    {
		        int k=(n-2*i-j)*2;
		        if(k>=0 && k<=a)
		            cnt+=1;
		    }
		}
		System.out.println(cnt);
	}
}
