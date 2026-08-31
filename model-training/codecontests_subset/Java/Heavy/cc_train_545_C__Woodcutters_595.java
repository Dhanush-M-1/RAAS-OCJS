import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		pair[] arr=new pair[n];
		int[] dir=new int[n];
		
		for(int i=0;i<n;i++)
		{
			int x=s.nextInt();
			int h=s.nextInt();
			
			pair p=new pair(x,h);
			arr[i]=p;
		}
		
		int count=1;
		
		for(int i=1;i<n;i++)
		{
			if(dir[i-1]==0)
			{
				int spaceleft=arr[i].x-arr[i-1].x-1;
				int spaceright=0;
				
				if(i==n-1)
				{
					spaceright=Integer.MAX_VALUE;
				}
				else
				{
					spaceright=arr[i+1].x-arr[i].x-1;
				}
				
				if(arr[i].h<=spaceleft)
				{
					count++;
				}
				else if(arr[i].h<=spaceright)
				{
					count++;
					dir[i]=1;
				}
			}
			else
			{
				int spaceleft=arr[i].x-(arr[i-1].x+arr[i-1].h)-1;
				int spaceright=0;
				
				if(i==n-1)
				{
					spaceright=Integer.MAX_VALUE;
				}
				else
				{
					spaceright=arr[i+1].x-arr[i].x-1;
				}
				
				if(arr[i].h<=spaceleft)
				{
					count++;
				}
				else if(arr[i].h<=spaceright)
				{
					dir[i]=1;
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	
}

class pair
{
	int x;
	int h;
	
	public pair(int x,int h)
	{
		this.x=x;
		this.h=h;
	}
}