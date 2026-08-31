import java.util.Scanner;

public class _0992TheBestGift {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] arr = new int[m+1];
		for(int i=0;i<n;i++) {
			arr[sc.nextInt()]++;
		}
		long ans=0;
		for(int i=1;i<m+1;i++) {
			for(int j=i+1;j<m+1;j++) {
				ans+=arr[i]*arr[j];
			}
		}
		System.out.println(ans);
	}

}
