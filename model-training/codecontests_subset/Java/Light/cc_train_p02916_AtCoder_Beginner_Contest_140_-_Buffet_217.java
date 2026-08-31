import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) a[i] = in.nextInt();
		int[] b = new int[n];
		for(int i=0;i<n;i++) b[i] = in.nextInt();
		int[] c = new int[n];
		for(int i=0;i<n-1;i++) c[i] = in.nextInt();
		int ans = b[a[0]-1];
		int pre = a[0];
		for(int i=1;i<n;i++) {
			ans += b[a[i]-1];
			if(pre+1==a[i]) ans += c[a[i]-2];
			pre = a[i];
		}
		System.out.print(ans);
		
		in.close();

	}

}
