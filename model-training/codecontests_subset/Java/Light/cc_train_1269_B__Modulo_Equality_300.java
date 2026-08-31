import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int m=s.nextInt();
		
		int[] arr=new int[n];
		int[] brr=new int[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++)
		{
			brr[i]=s.nextInt();
			
			if(map.containsKey(brr[i]))
			{
				map.put(brr[i],map.get(brr[i])+1);
			}
			else
			{
				map.put(brr[i], 1);
			}
		}
		
		int ans=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int x=0;
			
			if(brr[0]>=arr[i])
			{
				x=brr[0]-arr[i];
			}
			else
			{
				x=m-(arr[i]-brr[0]);
			}
			
			int[] temp=new int[n];
			
			for(int j=0;j<n;j++)
			{
				temp[j]=(arr[j]+x)%m;
			}
			
			HashMap<Integer,Integer> t=new HashMap<Integer,Integer>();
			
			for(int j=0;j<n;j++)
			{
				if(t.containsKey(temp[j]))
				{
					t.put(temp[j],t.get(temp[j])+1);
				}
				else
				{
					t.put(temp[j], 1);
				}
			}
			
			int p=0;
			
			for(Map.Entry<Integer, Integer> entry:map.entrySet())
			{
				int key=entry.getKey();
				int value=entry.getValue();
				
				if(t.containsKey(key)&&t.get(key)==value)
				{
					t.remove(key);
				}
				else
				{
					p=1;
					break;
				}
			}
			
			if(p==0&&t.size()==0)
			{
				if(x<ans)
					ans=x;
			}	
		}
		
		System.out.println(ans);
		
	}
}