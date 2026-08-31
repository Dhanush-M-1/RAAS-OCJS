
import java.util.*;

public class ReachMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		long [] values = new long[sc.nextInt()];
		long newMedian = sc.nextInt();
		
		for(int i = 0; i<values.length; i++)
		{
			values[i]=sc.nextInt();
		}
		Arrays.sort(values);
		
		
		long count = 0;
		int medianIndex = (values.length-1)/2;
		long median = values[medianIndex];
		
		
		
		
		
		if(median>newMedian)
		{
			for(int i = medianIndex; i>=0; i--)
			{
				if(values[i]>newMedian)
				{
					count+=(values[i]-newMedian);
				}else{
					break;
				}
				
			}
			System.out.print(count);
		}
		else if(median<newMedian)
		{
			for(int i = medianIndex; i<values.length; i++)
			{
				if(values[i]<newMedian)
				{
					count+=(newMedian-values[i]);
				}else{
					break;
				}
			}
			System.out.print(count);
		}
		else
		{
			System.out.print(0);
		}

	}

}
