import java.util.Arrays;
import java.util.Scanner;

public class BadTriangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0) {
			int n=scan.nextInt();
			int[] a =new int[n];
			for(int i=0;i<n;i++) {
				a[i]=scan.nextInt();
			}
			Arrays.sort(a);
			int a1=a[0],a2=a[1],a3=a[n-1];
			if(a1+a2<=a3) {
				System.out.println(1+" "+2+" "+n);
			}
			else System.out.println("-1");
		}

	}

}
