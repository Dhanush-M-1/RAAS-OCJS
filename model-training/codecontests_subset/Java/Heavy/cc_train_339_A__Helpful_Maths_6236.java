import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s1=new Scanner(System.in);
	String s=s1.nextLine();
	char ch[]=s.toCharArray();
	char chh[]=new char[ch.length];
	for(int i=0;i<ch.length;i++)
	{
		if(i==0)
		{
			chh[0]=ch[0];
		
		}
		else if(i!=0&&i%2==0)
		{
			chh[i-1]=ch[i];
		}
	}
	Arrays.sort(chh);
	for(int i=0;i<chh.length;i++)
	{
		if(i==chh.length-1)
		{
		System.out.print(chh[i]);	
		}
	            else if(i>chh.length/2-1)
		{
	System.out.print(chh[i]+"+");
	            }
	}
	}
}