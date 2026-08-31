import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] n = new int[t];
		for (int i = 0; i < t; i++) {
			n[i] = sc.nextInt();
		}
		solve(n);
	}
	
	public static void solve(int[] nums) {
		if (nums.length==1) {
			System.out.println("1 1");
			System.out.println(-nums[0]);
			System.out.println("1 1");
			System.out.println(0);
			System.out.println("1 1");
			System.out.println(0);
		}
		else {
			int[] mods = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				mods[i] = nums[i] % nums.length;
				if (mods[i] < 0) mods[i] += nums.length;
			}
			//System.out.println(Arrays.toString(nums));
			System.out.println("1 1");
			System.out.println(-nums[0]);
			System.out.println("2 " + nums.length);
			for (int i = 1; i < nums.length; i++) {
				System.out.print((long)(nums.length-1)*(long)mods[i]+" ");
			}
			System.out.println();
			System.out.println("1 " + nums.length);
			System.out.print("0 ");
			for (int i = 1; i < nums.length; i++) {
				System.out.print(-((long)nums[i]+(long)mods[i]*(long)(nums.length-1)) + " ");
			}
		}
		
	}
	
}	