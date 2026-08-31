import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Edu33D {
	
	public static void main(String[] args) {
		FS scan = new FS(System.in);
		int N = scan.nextInt();
		int D = scan.nextInt();
		
		int[] list = new int[N];
		for(int i=0;i<N;i++) {
			list[i] = scan.nextInt();
		}
		
		long sum = 0;
		long surplus = 0;
		int sol = 0;
		boolean valid = true;
		for(int i=0;i<N;i++) {
			if(list[i]==0) {
				if(sum < 0) {
					sum = D;
					sol ++;
					surplus = D;
				}else {
					surplus = Math.min(surplus, sum);
				}
			}else {
				sum+=list[i];
			}
			if(sum>D && sum - D <= surplus) {
				surplus-=sum - D;
				sum -= sum - D;
			}else if (sum > D ) {
				valid = false;
				break;
			}
		}
		System.out.println(valid?sol:-1);
	}
	private static class FS {
        BufferedReader br;
        StringTokenizer st;
        public FS(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try{st = new StringTokenizer(br.readLine());}
                catch(IOException e){e.printStackTrace();}
            }
            return st.nextToken();
        }
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() { return Double.parseDouble(next());}
    }
}