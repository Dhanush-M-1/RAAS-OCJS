import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		int[] c = new int[n];
		int sum=0;
		for(int i=1;i<=n;i++) {
			a[i]=sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			b[i]=sc.nextInt();
		}
		for(int i=1;i<=n-1;i++) {
			c[i]=sc.nextInt();
		}
		for(int i=1;i<n;i++) {
			if(a[i+1]-a[i]==1) {
				sum=sum+b[a[i]]+c[a[i]];
			//	System.out.println(sum);
			}
			else {
				sum=sum+b[a[i]];
			//	System.out.println(sum);
			}
		}
		sum=sum+b[a[n]];
		System.out.println(sum);
	}

}
