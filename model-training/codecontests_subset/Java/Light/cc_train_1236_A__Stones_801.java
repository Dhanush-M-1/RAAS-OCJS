import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int sum=0;
			while(c>=2 && b>=1){
				c-=2;
				b-=1;
				sum+=3;
			}
			while(b>=2 && a>=1){
				b-=2;
				a-=1;
				sum+=3;
			}
			System.out.println(sum);
		}
	}
}