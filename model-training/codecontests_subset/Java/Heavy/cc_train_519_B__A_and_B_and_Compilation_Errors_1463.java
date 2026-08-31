import java.util.*;
import java.io.*;

public class B519 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());

		HashMap<Integer, Integer> errors = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> fixed = new HashMap<Integer, Integer>();

		for(int i = 0; i < 3; i++) {
			errors = (HashMap<Integer, Integer>)(fixed.clone());
			fixed = new HashMap<Integer, Integer>();

			StringTokenizer st = new StringTokenizer(in.readLine());

			while(st.hasMoreTokens()) {
				int t = Integer.parseInt(st.nextToken());
				fixed.put(t, 1 + (fixed.containsKey(t) ? fixed.get(t) : 0));
			}

			if(errors.size() > 0) {
				for(Integer key : errors.keySet()) {
					if(fixed.get(key) == null || errors.get(key) > fixed.get(key)) {
						System.out.println(key);
						break;
					}
				} 
			}
		}

	}

}
