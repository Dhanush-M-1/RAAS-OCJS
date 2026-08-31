import java.util.*;
import java.io.*;


public class Main implements Runnable {
	private int get(int bCnt){
                int cCnt = Integer.MAX_VALUE;
                for(int i = 0; i < 26; i++){
                                int left = A[i] - bCnt * B[i];
                                if(left < 0) // this bCnt is not possible
                                        return -1;
                                if(C[i] > 0) cCnt = Math.min(cCnt, left / C[i]);
                        
                }
                
                return bCnt  + cCnt;
        }	
        
        int[] A, B, C;
	public void solve() throws IOException {
               String a = nextToken();
               String b = nextToken();
               String c = nextToken();
               
               A = new int[26];
               B = new int[26];
               C = new int[26];
               for(char cc : a.toCharArray()) A[cc - 'a']++;
               for(char cc : b.toCharArray()) B[cc - 'a']++;
               for(char cc : c.toCharArray()) C[cc - 'a']++;
               
               int bCnt = 0;
               int tCnt = 0;
               for(int i = 0; ; i++){
                       int now = get(i);
                       if(now == -1)
                               break;
                       if(now > tCnt){
                               tCnt = now;
                               bCnt = i;
                       }
               }
               
               int cCnt = tCnt - bCnt;
               
               for(int i = 0; i < bCnt; i++)
                       out.print(b);
               for(int i = 0; i < cCnt; i++)
                       out.print(c);
               for(int i = 0; i < 26; i++){
                       int now = A[i] - bCnt * B[i] - cCnt * C[i];
                       if(now > 0){
                               while(now-- > 0){
                                       out.print((char)(i+'a'));
                               }
                       }
               }
               out.println();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Main().run();
	}

        public void debug(Object... arr){
            System.out.println(Arrays.deepToString(arr));
        }

        public void print1Int(int[] a){
                for(int i = 0; i < a.length; i++)
                        System.out.print(a[i] + " ");
                System.out.println();
        }
        
        public void print2Int(int[][] a){
                for(int i = 0; i < a.length; i++){
                        for(int j = 0; j < a[0].length; j++){
                                System.out.print(a[i][j] + " ");
                        }
                        System.out.println();
                }
        }
        
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
                        out = new PrintWriter(System.out);
			tok = null;
			solve();
			in.close();
                        out.close();
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
        PrintWriter out;
	BufferedReader in;
	StringTokenizer tok;
}