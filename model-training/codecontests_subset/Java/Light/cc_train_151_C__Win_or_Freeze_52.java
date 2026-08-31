import java.util.*;
import java.math.*;
import java.io.*;

public class Main
	{
	public static void main(String args[]) throws IOException
		{
		Scanner c=new Scanner(System.in);
		long N=c.nextLong();
		int MAX=100000;
		int A[]=new int[MAX];		//10M
		int len=primeL(N);
		if(len==1)
			{
			System.out.println(1);
			System.out.println(0);
			return;
			}
		if(len==2)			//product of 2 primes
			{
			System.out.println(2);
			return;
			}
		else
			{
			int P[]=primeA(N);
			//System.out.println("prime array: "+Arrays.toString(P));
			System.out.println(1);
			System.out.println(P[0]*P[1]);
			}
		}
	
	public static int primeL(long N)
		{
		if(N==1)
			return 1;
		int len = 0;
		for (long i = 2; i * i <= N; i++)
			{
			while (N % i == 0)
				{
				N = N / i;
				len++;
				}
			}
		if (N > 1) //a residue prime number
			len++;
		return len;
		}
	
	public static int[] primeA(long N)
		{
		int A[]=new int[2];
		int index=0;
		for (long i = 2; i * i <= N; i++)
			{
			while(N%i==0)
				{
				N = N / i;
				A[index]=(int)i;
				if(index!=1)
					index++;
				}
			}
		return A;
		}
	}

//must declare new classes here