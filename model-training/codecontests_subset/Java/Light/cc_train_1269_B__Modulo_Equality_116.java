import java.util.Arrays;
import java.util.Scanner;

public class B609 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n =scan.nextInt();
		int m =scan.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i = 0;i<n;i++) {
			a[i] = scan.nextInt();
		}
		for(int i = 0;i<n;i++) {
			b[i] = scan.nextInt();
		}
		Arrays.sort(b);
		//Arrays.sort(b);
		int ans = m;
		for(int i = 0;i<n;i++) {
			int need = (b[i]-a[0]+m)%m;
//			int need = 0;
//			if(a[i]<=b[0]) {
//				need = b[0]-a[0];
//			}else {
//				need = b[0]+(m-a[0]);
//			}
			boolean good = true;
			//System.out.print("I "+i+" ");
			int[] temp = new int[n];
			for(int j = 0;j<n;j++) {
				int res = (a[j]+need)%m;
				temp[j] = res;
//				
//				System.out.print(res+" ");
//				if(res!=b[j]) {
//					good = false;
//				}
			}
			Arrays.sort(temp);
			for(int j = 0 ;j<n;j++) {
				if(temp[j]!=b[j]) {
					good = false;
				}
			}
			//System.out.println();
			if(good)ans = Math.min(ans, need);
		}
		System.out.println(ans);
	}

}
