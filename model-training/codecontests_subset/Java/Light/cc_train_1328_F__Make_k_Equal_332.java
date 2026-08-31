import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]), k = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(str[i]);
		List<Integer>[] values = new ArrayList[200009];
		for(int i=0; i<200009; i++) values[i] = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			int x = arr[i];
			int cnt = 0;
			while(x>0) {
				values[x].add(cnt);
				cnt++;
				x = x>>1;
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<200009; i++) {
			if(values[i].size()>=k) {
				Collections.sort(values[i]);
				int tmpAns = 0;
				for(int j=0; j<k; j++) tmpAns+=values[i].get(j);
				ans = Math.min(ans, tmpAns);
			}
		}
		System.out.println(ans);
	}
}
