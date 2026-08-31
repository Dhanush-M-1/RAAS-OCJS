import java.util.Scanner;

public class Try1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]= new int [n];
		int sum=0;
		int sum2=0;
		int maxx = 0;
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
			if(arr[i]>maxx) {
				maxx=arr[i];
			}
		}
		for(int k=0;k<100000;k++) {
			if(k*n>2*sum) {
				sum2 = k;
				break;
			}
		}
		System.out.println(Math.max(maxx, sum2));
		
	}

}
