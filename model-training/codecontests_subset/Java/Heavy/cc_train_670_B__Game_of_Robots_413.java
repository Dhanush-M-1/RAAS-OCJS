import java.util.*;

public class CF670B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		long k = in.nextInt();
		int[] ids = new int[n];
		
		for(int i = 0; i < n; ++i) {
			ids[i] = in.nextInt();
		}
		
		long lo = 1;
		long hi = n+2;
		while(lo < hi) {
			long mid = lo + (hi-lo)/2;
			long kMin = mid*(mid-1)/2 + 1;
			long kMax = kMin + mid - 1;
			//System.out.println(mid + " " + kMin + " " + kMax);
			
			if(kMin <= k && k <= kMax) {
				lo = mid;
				break;
			} else if(k < kMin) {
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		
		//System.out.println(lo);
		long offset = k - (lo*(lo-1)/2 + 1);
		System.out.println(ids[(int)(offset)]);
	}
}