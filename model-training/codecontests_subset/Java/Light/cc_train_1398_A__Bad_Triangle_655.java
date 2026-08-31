import java.util.*;
public class solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			if(n<3)
				System.out.println("-1");
			else
			{   
				
				 if(arr[0]+arr[1]<=arr[n-1])
				 {
					System.out.println(1+" "+2+" "+n);
				 }
				 else
					 System.out.println("-1");
					
				}
				
			}
		}

	}
