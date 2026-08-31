
import java.util.*;
import java.lang.*;
import java.io.*;

public class err
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum1=0,sum2=0,sum3=0;
		int a=n-1;
		int b=n-2;
		while(n-->0){
		    sum1+=sc.nextInt();
		}
		while(a-->0){
		    sum2+=sc.nextInt();
		}
		while(b-->0){
		    sum3+=sc.nextInt();
		}
		System.out.println(sum1-sum2);
		System.out.println(sum2-sum3);
		
	}
}
