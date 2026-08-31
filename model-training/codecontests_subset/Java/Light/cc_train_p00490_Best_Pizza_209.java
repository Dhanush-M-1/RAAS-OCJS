import java.util.Scanner;

public class Main
{	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int  toppingN   = sc.nextInt();
		int  valBase    = sc.nextInt();
		int  valTopping = sc.nextInt();
		int  calBase    = sc.nextInt();
		int[]calTopping = new int[toppingN];
		
		for(int i=0; i<toppingN; i++)
			calTopping[i] = sc.nextInt();
		java.util.Arrays.sort(calTopping);

		int currCal =calBase;
		int currVal =valBase;
		for(int i=toppingN-1; i>=0; i--)
		{
			int nextCal = currCal +calTopping[i];
			int nextVal = currVal +valTopping;
			
			if( ((double)nextCal/nextVal) > ((double)currCal/currVal) )
			{
				currCal = nextCal;
				currVal = nextVal;
			}
			else break;
		}
		System.out.println(currCal/currVal);
	}
}