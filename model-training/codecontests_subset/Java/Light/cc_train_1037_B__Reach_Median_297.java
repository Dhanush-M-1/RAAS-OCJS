import java.util.Scanner;
import java.util.Arrays;
public class Main {
	
	public static void main(String[] args) {
		
		Scanner Reader=new Scanner(System.in); 
		
		int N=Reader.nextInt();
		long s=Reader.nextLong();
		long[] arr=new long[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Reader.nextLong();
		}
		long sum=0;
		Arrays.sort(arr);
		
		if(arr[N/2]<s)
		{
			for(int i=N/2;i<N;i++)
			{
				if(s-arr[i]>0)
					sum+=(s-arr[i]);
				else
					break;
			}
		}
		else if(arr[N/2]>s)
		{
			for(int i=N/2;i>=0;i--)
			{
				if(arr[i]-s>0)
					sum+=(arr[i]-s);
				else
					break;
			}
		}
		System.out.print(sum);
	}
}
