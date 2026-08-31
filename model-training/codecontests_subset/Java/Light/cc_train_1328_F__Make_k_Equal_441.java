import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class EqualizingByDivision {
	private static int[] nums;
	private static int n, k, ops, finalOps = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer s = new StringTokenizer(b.readLine());
		n = Integer.parseInt(s.nextToken());
		k = Integer.parseInt(s.nextToken());
		nums = new int[n];
		s = new StringTokenizer(b.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(s.nextToken());
		}
		Arrays.sort(nums);
		int before = -1;
		for(int i = 0; i <= nums[n - 1]; i++) {
			calcOps(i);
			if(ops < finalOps) {
				finalOps = ops;
			}				
			ops = 0;
		}
		p.println(finalOps);
		p.close();
	}
	private static void calcOps(int s) {
		int count = 0, num, opsToGet = 0;
		for(int i = 0; i < n && count != k; i++) {
			num = nums[i];
			if(num >= s) {
				if(num == s) {
					count++;
				}
				else {
					while(num > s) {
						num /= 2;
						opsToGet++;
					}
					if(num == s) {
						count++;
						ops += opsToGet;
					}
					opsToGet = 0;
				}
			}
		}
		if(count != k) {
			ops = Integer.MAX_VALUE;
		}
	}
}