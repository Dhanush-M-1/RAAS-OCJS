import java.util.Scanner;

public class Round519 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int max=Integer.MIN_VALUE;
		int rsum=0;
		int[] arr= new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			rsum=rsum+arr[i];
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.println(findMinK(rsum,max,n));
		
	}
	
	public static int findMinK(int r,int m,int n) {
		
		while(true) {
			if((m*n-2*r)>0) return m;
			m++;
		}
		
	}

}
