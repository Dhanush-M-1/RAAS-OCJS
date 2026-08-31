import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = Integer.parseInt(st.nextToken());
		int v0 = Integer.parseInt(st.nextToken());
		int v1 = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int days = 0;
		int previous = v0;
		days++;
		total -= v0;
		while(total > 0) {
			int toSubtract = Math.min(v0 + days*a, v1) - l;
			total -= toSubtract;
			days++;
			previous = toSubtract;
		}
		System.out.println(days);
	}
	
}