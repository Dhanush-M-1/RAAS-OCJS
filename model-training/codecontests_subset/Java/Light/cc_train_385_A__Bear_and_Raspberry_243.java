import java.util.Scanner;

public class BearandRaspberry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner cin = new Scanner(System.in); 
		int n=cin.nextInt();
		int c=cin.nextInt();
		int arr[]=new int[n];
		 for(int i=0;i<n;i++){
		   arr[i]=cin.nextInt();	
		}
		 
		 int max=Integer.MIN_VALUE;
		 for(int i = 0;i<n;i++){
			 if(i!=n-1 && arr[i]-arr[i+1]-c > max)
				 max=arr[i]-arr[i+1]-c;
		 }
		 if(max > 0)
		 System.out.println(max);
		 else
			 System.out.println(0);
		
	}

}
