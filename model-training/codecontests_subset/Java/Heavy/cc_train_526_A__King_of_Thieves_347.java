
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
	static int [][][] dp ;
	static int n ; 
	static char [] array;
	
	private static int fill(int index,int platforms,int jump) {
		
		if(platforms == 4) return 1;
		
		if(index+jump >=n) return 0;


		if(dp[index][platforms][jump]!=-1) return dp[index][platforms][jump];
		
		int answer = 0;
		
			if(array[index+jump]=='*')
				answer = Math.max(answer, fill(index+jump, platforms+1,jump));
		
		return dp[index][platforms][jump] = answer;
	}
	private static void solve() {

		
		 n = nextInt();
		
	  array = next().toCharArray();
		
		dp = new int [100][4][26];
		
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[i].length;j++)
				for(int k=0;k<=25;k++)
				dp[i][j][k] = -1;
		
		int answer = 0;
		for(int i=0;i<array.length-1;i++){
			if(array[i] == '*') {
				for(int nata = 1;nata<=25;nata++)
			answer = Math.max(answer,fill(i,0,nata));
			
			}
		}
		
		out.println(answer == 0 ? "no":"yes");
	}
	
    private static void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    private static StringTokenizer st;
    private static BufferedReader br;
    private static PrintWriter out;

    private static String next() {
        while (st == null || !st.hasMoreElements()) {
            String s;
            try {
                s = br.readLine();
            } catch (IOException e) {
                return null;
            }
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }

    private static long nextLong() {
        return Long.parseLong(next());
    }

    public static void main(String[] args) {
        run();
    }
}
