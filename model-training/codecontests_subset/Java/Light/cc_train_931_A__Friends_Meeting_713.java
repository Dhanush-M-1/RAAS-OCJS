import java.io.*;
import java.util.*;
public class sol
{
public static void main(String []args)
{
Scanner sc=new Scanner(System.in);
int a=sc.nextInt();
int b=sc.nextInt();
if(a>b)
{
	int sum1=0,sum=0;
	for(int i=1;a!=b;i++)
	{
	      a=a-1;
	    sum=sum+i;
		if(a!=b)
		{
		b=b+1;
		sum1=sum1+i;
		}
	}
	System.out.print(sum1+sum);
	System.exit(0);
}
else
	{
int sum2=0,sum3=0;
	for(int i=1;a!=b;i++)
	{
	      a=a+1;
	    sum2=sum2+i;
		if(a!=b)
		{
		b=b-1;
		sum3=sum3+i;
		}
	}
	System.out.print(sum3+sum2);
	System.exit(0);
}
}
}


