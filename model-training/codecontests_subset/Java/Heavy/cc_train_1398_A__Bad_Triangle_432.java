import java.io.*;
import java.util.*;
public class code
{
    public static  void check(int b[],int a)
    {
        for(int i=0;i<a-1;i++)
	       {
	           if(b[i]+b[i+1]<=b[a-1])
	           {
	               System.out.println(i+1+" "+(i+2)+" "+a);
	               return;
	           }
	       }
	       System.out.println(-1);
	       return;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
	   int t=sc.nextInt();
	   while(t-->0)
	   {
	       int a=sc.nextInt();
	       int b[]=new int[a];
	       for(int i=0;i<a;i++)
	       {
	           b[i]=sc.nextInt();
	       }
	       check(b,a);
	   }
    }
}