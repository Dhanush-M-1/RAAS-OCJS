import java.util.*;
import java.io.*;

public class Main implements Runnable {
        int[] dates = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        private boolean check(String s){
                if(! (s.charAt(2) == '-' && s.charAt(5) == '-')) return false;
                for(int i = 0; i < 10; i++){
                        if(i == 2 || i == 5) continue;
                        if(!(Character.isDigit(s.charAt(i)))) return false;
                }
                
                int date = Integer.parseInt(s.substring(0, 2));
                int month = Integer.parseInt(s.substring(3, 5));
                int year = Integer.parseInt(s.substring(6, 10));
                
                if(year >= 2013 && year <= 2015){
                        if(month >= 1 && month <= 12){
                                if(date >= 1 && date <= dates[month]){
                                        return true;
                                }
                        }
                }
                
                return false;
        }
        
	public void solve() throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
                String s = nextToken();
                for(int i = 0; i < s.length() - 9; i++){
                        String now = s.substring(i, i + 10);
                        if(!check(now)) continue;
                        if(! map.containsKey(now)) map.put(now, 1);
                        else map.put(now, map.get(now) + 1);
                }
                
                int cnt = -1;
                String ans = "";
                for(Map.Entry<String, Integer> me : map.entrySet()){
                        String now = me.getKey();
                        int n = me.getValue();
                        if(n > cnt){
                                cnt = n;
                                ans = now;
                        }
                }
                
                System.out.println(ans);
                
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			tok = null;
			solve();
			in.close();
		} catch (IOException e) {
			System.exit(0);
		}
	}

	public String nextToken() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	BufferedReader in;
	StringTokenizer tok;
}