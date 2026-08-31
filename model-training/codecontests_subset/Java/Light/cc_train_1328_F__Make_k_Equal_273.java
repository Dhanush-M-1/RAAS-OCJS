import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int k=s.nextInt();
		
		Integer[] arr=new Integer[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
		
		Arrays.sort(arr);
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		Map<Integer,Integer>[] brr=new HashMap[n];
		
		for(int i=0;i<n;i++)
		{
			Map<Integer,Integer> ma=new HashMap<Integer,Integer>();
			
			brr[i]=ma;
			
			int count=0;
			
			while(arr[i]>0)
			{
				brr[i].put(arr[i],count);
				
				if(!map.containsKey(arr[i]))
				{
					map.put(arr[i],1);
				}
				
				count++;
				arr[i]=arr[i]/2;
			}
			
			brr[i].put(0,count);
			
			if(!map.containsKey(arr[i]))
			{
				map.put(arr[i],1);
			}
			
		}
		
		int min=Integer.MAX_VALUE;
		
		for(Map.Entry<Integer,Integer> entry: map.entrySet())
		{
			int check=entry.getKey();
			//System.out.println(check);
			
			int count=0;
			
			int temp=0;
			
			for(int i=0;i<n;i++)
			{
				if(brr[i].containsKey(check))
				{
					temp=temp+brr[i].get(check);
					count++;
				}
				if(count==k)
					break;
			}
			
			if(count==k&&min>temp)
				min=temp;
		}
		
		System.out.println(min);
		
	}
	
}