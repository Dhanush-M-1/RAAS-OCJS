import java.util.*;
import java.io.*;

public class Bet
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[] a = new int[5];
		int sum = 0;
		for(int i=0;i<5;i++)
		{
			a[i] = in.nextInt();
			sum+=a[i];
		}
		int p = sum/5;
		int div = 0;
		for(int i=0;i<5;i++)
		{
			div = div + p - a[i];
		}
		
		if(div==0 && p!=0)
			System.out.println(p);
		else 
			System.out.println("-1");
	}
}