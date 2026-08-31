import java.io.*;
import java.util.*;

public class cf2014C {
    public static void main(String[] args) throws Exception {
    	// BufferedReader in = new BufferedReader(new FileReader("cf2014C.in"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
		String str = in.readLine();
		int n = Integer.parseInt(str.substring(0, str.indexOf(" ")));
		int m = Integer.parseInt(str.substring(str.indexOf(" ") + 1));
		
		String[] arr = in.readLine().split(" ");
		
		int[] w = new int[arr.length];
		for(int i = 0; i < w.length; i++) {
			w[i] = Integer.parseInt(arr[i]);
		}
		
		arr = in.readLine().split(" ");
		
		int[] b = new int[arr.length];
		for(int i = 0; i < b.length; i++) {
			b[i] = Integer.parseInt(arr[i]) - 1;
		}
		boolean[] hV = new boolean[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			if(!hV[b[i]]) {
				hV[b[i]] = true;
				list.add(b[i]);
			}
		}
		for(int i = 0; i < n; i++) {
			if(!hV[i]) {
				list.add(i);
			}
		}
		int[] order = new int[n];
		for(int i = 0; i < n; i++) {
			order[i] = list.get(i);
		}
		long total = 0;
		for(int i = 0; i < m; i++) {
			int search = b[i];
			boolean found = false;
			for(int j = n - 1; j > -1; j--) {
				if(found) {
					total += w[order[j]];
					order[j + 1] = order[j];
				} else {
					if(order[j] == search) {
						found = true;
					}
				}
			}
			order[0] = search;
		}
		System.out.println(total);
	}
}