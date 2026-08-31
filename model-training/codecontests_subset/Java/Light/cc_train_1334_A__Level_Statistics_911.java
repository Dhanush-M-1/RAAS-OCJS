import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution{
	public static void validLevel(int n,int a[][]) {
		if(a[0][0]<a[0][1]) {
			System.out.println("No");
			return;
		}
		for(int i=1;i<n;i++) {
			if(a[i][0]-a[i-1][0]< 0||(a[i][0]-a[i-1][0]<a[i][1]-a[i-1][1])||a[i][1]-a[i-1][1]<0||(a[i][0]<a[i][1])) {
				//System.out.println(a[i][0]-a[i-1][0]);
				System.out.println("No");
				return;
			}
			
		}
		System.out.println("Yes");
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=0,n=0;
		 T=sc.nextInt();
		//int n=sc.nextInt();
		//int arr[]
		while(T>0) {
			if(sc.hasNextInt() )
			     n = sc.nextInt(); // if there is another number  
			else 
			     n = 0; // nothing added in the input 
			//int n=sc.nextInt();
			int[][] arr=new int[n][2];
			
			
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[i][0]=a;
				arr[i][1]=b;
				}

			//for (int i = 0; i < n; i++) {
				//System.out.println(arr[i][0]+" "+arr [i][1]);
				//}
			
		
			validLevel(n, arr);
			T--;
		}
		//sc.close();
		
		
	}
}