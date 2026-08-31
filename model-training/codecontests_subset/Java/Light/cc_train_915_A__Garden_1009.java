import java.io.*;
import java.util.*;
public class CFC {
	public static void main (String[] args) {
		int n,k;
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		k=input.nextInt();
		int array[]=new int[n];
		int temp=0;
		int min=10000000;
		for(int i=0;i<n;i++)
		{
		    temp=input.nextInt();
		    if(k%temp==0)
		    {
		        if(min>(k/temp))
		        min=k/temp;
		    }
		}
		
		System.out.println(min);
	}
}