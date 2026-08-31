import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		strs = br.readLine().split(" ");
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			int num = Integer.parseInt(strs[i]);
			if (!map.containsKey(num)) { map.put(num, 0); }
			map.put(num, map.get(num) + 1);
		}
		List<int[]> nums = new ArrayList<>();
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			nums.add(new int[] {e.getKey(), e.getValue()});
		}
		nums.sort(new Comparator<int[]>() {
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});
		
		int numRemaining = n;
		
		for (int i = 1; i < nums.size(); i++) {
			if (nums.get(i)[0] <= nums.get(i - 1)[0] + K) {
				numRemaining -= nums.get(i - 1)[1];
			}
		}
		System.out.println(numRemaining);
	}

}
