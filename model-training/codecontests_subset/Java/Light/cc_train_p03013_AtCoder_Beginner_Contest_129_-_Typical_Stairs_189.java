import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int[] a = new int[n+1];
		for(int i=0;i<m;i++)a[sc.nextInt()-1]++;
		long sum=0,n1=2,n2=1;
		if(a[0]!=0) {
			n2=0;
			n1=1;
		}
		if(a[1]!=0)n1=0;
		for(int i=3;i<=n;i++) {
			if(a[i-1]!=0)sum=0;
			else sum=(n1+n2)%1000000007;
			n2=n1;
			n1=sum;
		}
		if(n==2)sum=n1;
		if(n==1)sum=n2;
		if(sum<0)sum=0;
		System.out.print(sum);

	}
}

