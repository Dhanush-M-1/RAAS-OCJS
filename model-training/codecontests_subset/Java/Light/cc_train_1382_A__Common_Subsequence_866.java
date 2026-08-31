import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
public class A71 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; 
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		solve();
	}
	public static void solve() throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for(int sss = 0;sss<n;sss++) {
			st = new StringTokenizer(br.readLine());
			int l =  Integer.parseInt(st.nextToken()), m =  Integer.parseInt(st.nextToken());
			int[]arr1 = new int[l];
			int[]arr2 = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<l;i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<m;i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			boolean frag  = false;
			for(int i = 0;i<l;i++) {
				int curNum = arr1[i];
				for(int j = 0;j<m;j++) {
					if(curNum==arr2[j]) {
						System.out.println("YES");
						System.out.println(1+" "+curNum);
						frag = true;
						break;
					}
				}
				if(frag)break;
			}
			if(!frag)System.out.println("NO");
		}
	}
	
}
