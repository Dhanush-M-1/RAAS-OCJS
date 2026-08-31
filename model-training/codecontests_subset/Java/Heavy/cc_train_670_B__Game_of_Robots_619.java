import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class BearFair {
	public static void main(String[] arsd){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n+1];
		long k = in.nextInt();
		for(int i = 1;i<=n;i++){
			a[i] = in.nextInt();
		}
		long l = 0;
		long r = 100000;
		while(r-l>1){
			long mid = (l+r)/2;
			long ans = ((mid)*(mid+1))/2;
			if(ans<=k){
				l = mid;
			}
			else{
				r = mid;
			}
		}
		long ans = ((l)*(l+1))/2;
		if(ans==k){
			System.out.println(a[(int)l]);
		}
		else{
			k-=ans;
			System.out.println(a[(int)k]);
		}
		in.close();
	}
}