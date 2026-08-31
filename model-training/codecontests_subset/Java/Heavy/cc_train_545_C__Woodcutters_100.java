import java.util.Scanner;



public class Main {
	
	public static void main(String args[]){
	
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int arr[][]=new int[n][2];
		
		for(int i=0;i<n;i++)
		{
			arr[i][0]=s.nextInt();
			arr[i][1]=s.nextInt();
		}
		int count=0;
		boolean previousfallen=false; //true if fallen right else false
		for(int i=1;i<n-1;i++)
		{
			int leftspace=0;
			int rightspace=0;
			if(previousfallen)
			leftspace=arr[i][0]-arr[i-1][0]-arr[i-1][1];
			else
			leftspace=arr[i][0]-arr[i-1][0];
			
			rightspace=arr[i+1][0]-arr[i][0];
			
			if(leftspace>arr[i][1])
			{
				count++;
				
				previousfallen=false;
			}
			else if(rightspace>arr[i][1])
			{
				count++;
				
				previousfallen=true;
			}
			else
			{
				previousfallen=false;
			}
			
				
			
		}
		
		if(n==1)
		System.out.println(count+1);
		else
		System.out.println(count+2);	
		
	}
	
	
	
	
}
