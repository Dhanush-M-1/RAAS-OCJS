import java.util.Scanner;
import java.util.Arrays;

public class Hello {

	public static void main(String[] args)
	{
	
		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		
		int[] a= new int[length];
		
		for(int i=0;i<length;i++)
		{
			a[i]=s.nextInt();
		}
		
		int[] odd1= new int[length];
		int[] even1= new int[length];
		
		int j=0;
		int k=0;
		
		for(int i=0;i<length;i++)
		{
			
	
			if(a[i]%2==0)
			{
				even1[j]=a[i];
				j++;
			}
			else
			{
				odd1[k]=a[i];
				k++;
				
			}
		}	
		
		int[] odd= new int[k];
		int[] even= new int[j];
		
		for(int i=0;i<k;i++)	
			odd[i]=odd1[i];
		
		for(int i=0;i<j;i++)	
			even[i]=even1[i];
		
			
			
		Arrays.sort(even); //j
		Arrays.sort(odd); //k
		
		
			
		if((j-k)<2 && -2<j-k)
			System.out.print(0);
		else
		{
			if(j<k)
			{
				int summ=0;
				
				for(int i=0;i<k-j-1;i++)
				{
					summ+=odd[i];
					
				}
				
				System.out.print(summ);
			}
			else
			{
				int summ=0;
				
				for(int i=0;i<j-k-1;i++)
				{
					summ+=even[i];
				}
				
				System.out.print(summ);
			}
			
			
		}
			
		
	}

}
