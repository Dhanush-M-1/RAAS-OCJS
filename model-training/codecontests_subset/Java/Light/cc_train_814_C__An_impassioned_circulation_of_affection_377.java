import java.io.*;
import java.util.*;
 
public class Main2 {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		char[] array = in.readLine().toCharArray();
		
		
		int[][] values = new int[n+1][26];
		
		for(int i = 0; i < 26; i ++) {
			char ch = (char)('a' + i);
			
			for(int j = 1; j <= n; j ++) {
				
				// now do sliding window / 2-pointer
				int count = 0, max = 0;
				int l = 0, r = 0;
				while(l < n && r < n) {
					while(r < n && (count < j || array[r] == ch)) {
						if(array[r] != ch) count ++;
						r ++;
					}
					max = Math.max(max, r - l);
					if(array[l++] != ch) count --;
				}
				
				values[j][i] = max;
			}
		}
		
		int q = Integer.parseInt(in.readLine());
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < q; i ++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			int ch = st.nextToken().charAt(0) - 'a';
			ans.append(values[num][ch] + "\n");
		}
		
		System.out.print(ans.toString());
		
		in.close();
	}
}