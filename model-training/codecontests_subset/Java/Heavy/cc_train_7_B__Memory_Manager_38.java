import java.util.*;
import java.io.*;

public class Main implements Runnable {
		
	public void solve() throws IOException {
		int t = nextInt(); int m= nextInt();
                int[] memory = new int[m];
                int counter = 0;
                
                for(int i = 0; i < t; i++){
                        String s = nextToken();
                        if(s.equals("alloc")){
                                int req = nextInt();
                                int got = 0;
                                boolean ok = false;
                                
                                for(int j = 0; j < m; j++){
                                        if(memory[j] == 0){
                                                got++;
                                                if(got >= req){
                                                        ok = true;
                                                        ++counter;
                                                        for(int k = j;  k > j - req; k--) memory[k] = counter;
                                                        System.out.println(counter);
                                                        break;
                                                }
                                        }
                                        else{
                                                got = 0;
                                        }
                                }
                                
                                if(!ok)System.out.println("NULL");
                               // p(memory);
                        }
                        else if(s.equals("erase")){
                                int id = nextInt();
                                boolean ok = false;
                                if(id > 0)
                                for(int j = 0; j < m; j++)
                                        if(memory[j] == id){
                                                ok = true;
                                                memory[j] = 0;
                                        }
                                
                                if(!ok)System.out.println("ILLEGAL_ERASE_ARGUMENT");
                                //p(memory);
                        }
                        else{
                                int offset = 0;
                                for(int j = 0; j < m; j++){
                                        if(memory[j] > 0){
                                                memory[j - offset] = memory[j];
                                        }
                                        else
                                                offset++;
                                }
                                
                                for(int j = m - offset; j < m; j++) memory[j] = 0;
                                //p(memory);
                        }
                }
	}

	
	private void p(int[] a){
                for(int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
                System.out.println();
        }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Main().run();
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