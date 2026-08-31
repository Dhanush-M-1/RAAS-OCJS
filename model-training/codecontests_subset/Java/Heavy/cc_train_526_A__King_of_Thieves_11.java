import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A {
	public static void main(String[] args) throws Exception{
		int n = readInt();
		boolean platform[] = new boolean[n];
		String s = readString();
		for(int i = 0; i < n; i++){
			platform[i] = s.charAt(i) == '*';
		}
		boolean pos = false;
		for(int i = 1; i < n; i++){
			for(int j = 0; j < n; j++){
				if(possible(i, j, platform, n)){
					pos = true;
				}
			}
		}
		if(pos){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
	}

	private static boolean possible(int step, int start, boolean[] platform, int n) {
		int cur = start;
		if(!platform[cur]){
			return false;
		}
		for(int i = 0; i < 4; i++){
			cur+=step;
			if(cur >= n){
				return false;
			}
			if(!platform[cur]){
				return false;
			}
		}
		return true;
	}

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer(" ");
	static String readString() throws Exception{
		while(!st.hasMoreTokens()){
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
	static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
}
