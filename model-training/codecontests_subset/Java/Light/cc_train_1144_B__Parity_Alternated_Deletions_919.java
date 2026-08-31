
import java.util.Arrays;
import java.util.Scanner;

public class ParityAlternatedDecisions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] arr=new int[n];
		int odd=0;
		int even=0;
		for(int i=0;i<n;i++)
		{
			arr[i]=scanner.nextInt();
			if(arr[i]%2==0)
			{
				even++;
			}
			else
			{
				odd++;
			}
		}
		int[] od=new int[odd];
		int o=0;
		int e=0;
		int[] ev=new int[even];
		for(int i=0;i<n;i++)
		{
			if(arr[i]%2==0)
			{
				ev[e]=arr[i];
				e++;
			}
			else
			{
				od[o]=arr[i];
				o++;
			}
		}
		Arrays.sort(od);
		Arrays.sort(ev);
		if(Math.abs(odd-even)<=1)
		{
			System.out.println(0);
//			if(odd>even)
//			{
//				System.out.println(ev[0]);
//			}
//			else
//			{
//				System.out.println(od[0]);
//			}
		}
		else
		{
			if(odd>even)
			{
				long sum=0;
					odd=odd-even-1;
					for(int i=0;i<odd;i++)
					{
//						System.out.print(od[i] + " ");
						sum=sum+od[i];
						
					}
					System.out.println(sum);
			}
			else
			{
				even=even-odd-1;
				int sum=0;
				for(int i=0;i<even;i++)
				{
					sum=sum+ev[i];
//					System.out.print(ev[i] + " ");
				}
				System.out.println(sum);
			}
		}

	}

}
