import java.util.*;
public class ReachMedian {

	public static void main (String[] args) {
		Scanner in = new Scanner (System.in);
		int n = in.nextInt();
		int s = in.nextInt();
		long ops = 0;
		int[] arr = new int [n];
		for (int i = 0; i < n; i ++) arr[i] = in.nextInt();
		Arrays.sort(arr);
		int medianIndex = n / 2;
		int medianVal = arr[medianIndex];
		if (s > medianVal) {
			for (int i = medianIndex; i < n; i ++) {
				int predictedVal = s - arr[i];
				ops += (predictedVal > 0 ? predictedVal : 0);
			}
		}
		if (s < medianVal) {
			for (int i = medianIndex; i >= 0; i --) {
				int predictedVal = arr[i] - s;
				ops += (predictedVal > 0 ? predictedVal : 0);
			}		
		}
		System.out.println(ops);
	}

}
