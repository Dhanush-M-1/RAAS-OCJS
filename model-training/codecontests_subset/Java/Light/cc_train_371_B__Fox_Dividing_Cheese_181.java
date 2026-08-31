import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FoxDividingCheese {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tk;
	public static void main(String[] args) throws Exception{
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		tk = tk(in.readLine());
		int a = Integer.parseInt(tk.nextToken());
		int b = Integer.parseInt(tk.nextToken());
		
		int[] aans = solve(a);
		int[] bans = solve(b);
		
		if(aans[REM] != bans[REM]){
			out.println(-1);
		}else{
			int ans = 0;
			for(int i=1;i<=3;i++){
				ans+=Math.abs(aans[i]-bans[i]);
			}
			out.println(ans);
		}
		
		out.close();
	}
	
	static int REM = 0;
	static int TWO = 1;
	static int THREE = 2;
	static int FIVE = 3;
	static int[] solve(int a) {
		int[] ans = new int[4];
		while(a%2 == 0){
			a/=2;
			ans[TWO]++;
		}

		while(a%3 == 0){
			a/=3;
			ans[THREE]++;
		}
		while(a%5 == 0){
			a/=5;
			ans[FIVE]++;
		}
		ans[REM] = a;
		return ans;
	}
	
	
	
	static StringTokenizer tk(String s) {
		return new StringTokenizer(s);
	}
}
