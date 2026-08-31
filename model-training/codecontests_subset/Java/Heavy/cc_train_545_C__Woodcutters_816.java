import java.util.StringTokenizer;
import java.io.*;
public class wood{
	public static void main(String args[]) throws IOException {
      Reader in = new Reader();
      int n = in.nextInt();
      int arr[][] = new int[n+1][2];
      for(int i=0;i<n;i++) arr[i] = in.readArray(2);
      int dp[][] = new int[n][3];
      arr[n][0] = Integer.MAX_VALUE;
      dp[0][0] = 1;
      dp[0][1] = 1;
      dp[0][2] = 0;
      for(int i=1;i<n;i++){
          int l =  arr[i-1][0];
          int lh = arr[i-1][1];
          int r = arr[i+1][0];
          int c = arr[i][0];
          int h = arr[i][1];
          if(c-l>h){
              if(c-l-lh>h) dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2])) + 1;
              else dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]) + 1;
           }
          else dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
          if(r-c>h){
              dp[i][1] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]))+1;
          }
          else dp[i][1] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
          dp[i][2] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
          //System.out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]);
    }
      System.out.println(Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2])));
  }
	static class Reader{
		private BufferedReader rd;
		private StringTokenizer tk;
		Reader(){
			rd = new BufferedReader(new InputStreamReader(System.in));
			tk = null;
		}
		public String next() {
			while(tk==null || !tk.hasMoreElements()) {
				try {
					tk = new StringTokenizer(rd.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return tk.nextToken();
		}
		private int nextInt(){
			return Integer.parseInt(next());
		}
		private double nextdouble() {
			return Double.parseDouble(next());
		}
		private float nextfloat() {
			return Float.parseFloat(next());
		}
		private  int[] readArray(int n) {
			int arr[] = new int[n];
			for(int i=0;i<n;i++) arr[i] = nextInt();
			return arr;
		}
	}
}

