import java.util.*;
import java.io.*;
public class CodeforcesC545 {
	public static int[][] memo;
	public static int n;
	public static int[] xs, hs;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		xs = new int[n];
		hs = new int[n];
		
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			xs[i] = Integer.parseInt(st.nextToken());
			hs[i] = Integer.parseInt(st.nextToken());
		}
		
		memo = new int[2][n];
		for(int i = 0;i<2;i++){
			Arrays.fill(memo[i], -1);
		}
		
		System.out.println(go(0, 0));
		
	}
	public static int go(int flag, int pos){
		if(pos == n){
			return 0;
		}
		
		if(memo[flag][pos] != -1){
			return memo[flag][pos];
		}
		
		
		int leftPos = (pos == 0 ? -2000000002 : (flag == 1 ? xs[pos-1]+hs[pos-1] : xs[pos-1]));
		int rightPos = (pos == n-1 ? 2000000002 : xs[pos+1]);
		
		int max = go(0, pos+1);
		if(xs[pos]-hs[pos] > leftPos){
			max = Math.max(max, go(0, pos+1)+1);
		}
		if(xs[pos]+hs[pos] < rightPos){
			max = Math.max(max, go(1, pos+1)+1);
		}
		
		return memo[flag][pos] = max;
	}
}
