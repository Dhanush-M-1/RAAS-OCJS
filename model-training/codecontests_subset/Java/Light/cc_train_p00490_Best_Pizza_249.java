import java.util.Arrays;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		while(in.hasNext())
		{
			int N=in.nextInt();
			int a=in.nextInt(),b=in.nextInt();
			int ac=in.nextInt();
			int bc[]=new int[N];
			for(int i=0;i<N;i++)
				bc[i]=in.nextInt();
			int cost=a;
			int cal=ac;
			int max=cal/cost;
			Arrays.sort(bc);
			for(int i=N-1;i>=0;i--)
			{
				cost+=b;
				cal+=bc[i];
				max=Math.max(max, cal/cost);
			}
			System.out.println(max);
		}
	}
}