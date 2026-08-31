import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test {
	private static void twoBases(int[] xs, int bx, int[] ys, int by) {
		long x = 0, y = 0;
		for(int i=0; i<xs.length; i++)
			x = (long)bx*x + (long)xs[i];
		for(int i=0; i<ys.length; i++)
			y = (long)by*y + (long)ys[i];
		
		if(x < y)  
			System.out.println("<");
		else if(x > y)
			System.out.println(">");
		else
			System.out.println("=");
	}
	
	private static void longestContantRange(int[] nums) {
		int start=0, min=0, max=0, res=1;
		for(int i=1; i<nums.length; i++) {
			if(nums[min]==nums[max] || (nums[min]<=nums[i] && nums[i]<=nums[max])) {
				if(nums[i] >= nums[max])  max = i;
				else                      min = i;
			} else if(nums[i] < nums[min]) {
				res = Math.max(res, i-start);
				start = max+1;
				max = min;
				min = i;
			} else {
				res = Math.max(res,  i-start);
				start = min+1;
				min = max;
				max = i;
			}
		}
		res = Math.max(res, nums.length-start);
		System.out.println(res);
	}
	
	private static void bulbs(BufferedReader br) throws IOException {
		String[] s = br.readLine().split(" ");
		int n  = Integer.parseInt(s[0]);
		int m  = Integer.parseInt(s[1]);
		boolean[] bulb = new boolean[m];
		int ons = 0;
		for(int i=0; i<n; i++) {
			s = br.readLine().split(" ");
			int count = Integer.parseInt(s[0]);
			for(int j=0; j<count; j++) {
				int t = Integer.parseInt(s[j+1]);
				if(!bulb[t-1]) {
					ons++;
					bulb[t-1] = true;
				}
			}
		}
		if(ons == m)  System.out.println("YES");
		else		  System.out.println("NO");
	}
	
	public static void main(String[] args) throws InterruptedException {
		//new careercup().run();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			bulbs(br);
		}catch(IOException io){
			io.printStackTrace();
		}
	}
}
