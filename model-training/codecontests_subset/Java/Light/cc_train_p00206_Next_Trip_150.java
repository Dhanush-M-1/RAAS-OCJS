import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		
		int L,M,N,A,i;
		
		while(true)
		{
			L = cin.nextInt();
			if(L==0) { break; }
		
			for(i=0,A=0; i<12; i++)
			{	
				M = cin.nextInt();
				N = cin.nextInt();
		
				L -= (M-N);
				if(L<=0 && A==0) { A=i+1; }
			}
			
			if(A>0)
			{
				System.out.println(A);
			}
			else
			{
				System.out.println("NA");
			}
		}
	}
}