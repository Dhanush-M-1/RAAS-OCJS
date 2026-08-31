import java.util.Arrays;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=s.nextInt();
		}
		Arrays.sort(arr);
		if(arr[n/2]==m){
			System.out.println("0");
		}
		else if(arr[n/2]>m){
			long ans=0;
			int i=n/2;
			while(i>=0&&arr[i]>m){
				ans+=(arr[i]-m);
				i--;
			}
			System.out.println(ans);
		}
		else{
			long ans=0;
			int i=n/2;
			while(i<n&&arr[i]<m){
				ans+=(m-arr[i]);
				i++;
			}
			System.out.println(ans);
		}
	}
}
