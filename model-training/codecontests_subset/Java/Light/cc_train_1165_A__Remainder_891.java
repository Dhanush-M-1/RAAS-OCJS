/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int  n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		String str=sc.next();
		char ch[]=str.toCharArray();
		int inc=n-y;
		int count=0;
		for(int i=n-x;i<n;i++)
		{
		  //System.out.println(ch[i]);
		  if(i==n-(y+1)&&ch[i]!='1')
		  {
		    count++;
		    //System.out.println("1st"+ch[i]+count);
		  }
		  if(i!=(n-(y+1))&&ch[i]!='0')
		  {
		  count++;
		   //System.out.println("2st"+ch[i]+" "+i+count);
		  }
		}
		System.out.println(count);
	}
}
