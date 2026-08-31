import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
  public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s =new Scanner(System.in);
		int len=s.nextInt();
		int x=s.nextInt();
		int y=s.nextInt();
		int count=0;
		String str=s.next();
	   for(int i=0;i<x;i++)
	   {
	       if(str.charAt(len-1-i)!='0'&&i!=y){
	       count++;
	       }
	   }
	   if(str.charAt(len-y-1)!='1')
	   count++;
	   System.out.println(count);
	}
}