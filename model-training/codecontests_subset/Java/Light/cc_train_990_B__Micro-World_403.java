import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class microworld {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Integer[] nums = new Integer[n];
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		StringTokenizer st1 = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st1.nextToken());
			nums[i] = num;
			set.add(num);
		}
		
		Arrays.parallelSort(nums);
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(set.higher(nums[i]) == null)
				continue;
			int next = set.higher(nums[i]);
			if(nums[i] + k >= next)
				count++;
		}
		
		out.println(n - count);
		
		in.close();
		out.close();
	}
	
}
