import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int a[]=new int[n];
		int sum=0;
		int c[]=new int[n-1];
		for(int i=0;i<n;i++)a[i]=scan.nextInt();
		for(int i=0;i<n;i++)sum+=scan.nextInt();
		for(int i=0;i<n-1;i++)c[i]=scan.nextInt();
		scan.close();

		for(int i=1;i<n;i++) {
			if(a[i-1]==a[i]-1)sum+=c[a[i]-2];
		}
		System.out.println(sum);
	}

}