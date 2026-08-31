import java.util.Scanner;

public class Main{

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int i,j,n,min,swap,count=0;
		n=scan.nextInt();
		int arr[]=new int[n];
		for(i=0;i<n;i++) {
			arr[i]=scan.nextInt();
		}
		for(i=0;i<n;i++) {
			min=i;
			for(j=i;j<n;j++) {
				if(arr[min]>arr[j]) {
					min=j;
				}
			}
			if(min!=i) {
				swap=arr[min];
				arr[min]=arr[i];
				arr[i]=swap;
				count++;
			}
		}
		for(i=0;i<n;i++) {
			if(i<n-1) {
				System.out.print(arr[i]+" ");
			}
			else{
				System.out.println(arr[i]);
			}
		}
		System.out.println(count);
		scan.close();
	}
}
