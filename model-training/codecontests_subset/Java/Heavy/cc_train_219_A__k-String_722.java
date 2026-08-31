/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		String s=br.readLine();
		int a[]=new int[26];
		for(int i=0;i<s.length();i++)
            a[s.charAt(i)-97]++;
        boolean flag=true;
        String ans="";
        for(int i=0;i<26;i++)
        {
            if(a[i]%k==0)
            {
                a[i]/=k;
                for(int j=0;j<a[i];j++)
                    ans+=(char)(i+97);
            }
            else
            {
                flag=false;
                break;
            }
        }
        if(flag==false)
            System.out.println(-1);
        else
            for(int i=0;i<k;i++)
                System.out.print(ans);
	}
}