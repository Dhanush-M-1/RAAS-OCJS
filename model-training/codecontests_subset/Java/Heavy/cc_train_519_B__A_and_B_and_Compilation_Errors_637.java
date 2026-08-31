import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Compilation 
{
	
	
	public static void main(String args[]) throws FileNotFoundException
	{
		
		Scanner in = new Scanner ( System.in);
		
		int number= in.nextInt();
		
		int[] a= new int[number];
		for(int i=0;i<number;i++)
		{
			a[i]=in.nextInt();
		}
	
		Arrays.sort(a);
	
		int[] b= new int[number-1];
		for(int i=0;i<number-1;i++)
		{
			b[i]=in.nextInt();
			
		}
		Arrays.sort(b);
		System.out.println(a[giveI(a,b,number)]);
		
		int[] c= new int[number-2];
		for(int i=0;i<number-2;i++)
		{
			c[i]=in.nextInt();
		}
		Arrays.sort(c);
		System.out.println(b[giveI(b,c,number-1)]);
	}
	
	
	public static int giveI(int[] a, int[] b,int number)
	{
	for(int i=0;i<number-1;i++)
	{
		if(a[i]!=b[i])
		{
			return i;
		}
	}
	return number-1;
	}
	
	
}

