import java.io.*;
import java.util.*;


public class SolutionA {
	public void solve(){
		int n = nextInt();
		int ones = 0, twos = 0, sum =0;
		for(int i = 0 ; i < n ; i++){
			if(nextInt() == 100){
				ones++;
				sum++;
			}else{
				twos++;
				sum+=2;
			}
		}

		if(sum % 2 == 1){
			out.println("NO");
			return;
		}
		sum/=2;
		while(twos > 0 && sum > 1){
			sum-=2;
			twos--;
		}
		while(ones > 0 && sum > 0){
			sum--;
			ones--;
		}
		out.println(sum == 0 ? "YES":"NO");
	}
	public void run(){
		solve();
		out.close();
	}
	public static void main(String args[]){
		new SolutionA().run();
	}
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String line;
	StringTokenizer st;
	public String nextLine(){
		try {
			line = bf.readLine();
			st = new StringTokenizer(line);
		} catch (IOException e) {
			return null;
		}
		return line;
	}
	public String nextString(){
		while (st == null || !st.hasMoreElements()) {
            try {
                line = bf.readLine();
                st = new StringTokenizer(line);
            } catch (IOException e) {
                return null;
            }
        }
        return st.nextToken();
	}
	public int nextInt(){
		return Integer.parseInt(nextString());
	}
	public long nextLong(){
		return Long.parseLong(nextString());
	}
	public double nextDouble(){
		return Double.parseDouble(nextString());
	}
}
