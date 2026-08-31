import java.util.*;
import java.io.*;

public class Main {
	static final int M = 1000000007;
		static FastReader in = new FastReader();
		static PrintWriter out = new PrintWriter(System.out);
//		static Scanner in = new Scanner(System.in);
//        File file = new File("input.txt");
//        Scanner in = new Scanner(file);
//        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
    public static void main(String[] args) {
    	
    	int t = in.nextInt();
    	while(t-- > 0) {
    		int n = in.nextInt();
    		char[][] grid = new char[n][n];
    		for(int i = 0; i<n; i++) {
    			String str = in.next();
    			grid[i] = str.toCharArray();
    		}
    		if(grid[0][1] == '0' && grid[1][0] == '0' && grid[n-1][n-2] == '0' && grid[n-2][n-1] == '0') {
    			out.println(2);
    			out.println((n-1+1) + " " + (n-2+1));
    			out.println((n-2+1) + " " + (n-1+1));
    		}else if(grid[0][1] == '1' && grid[1][0] == '0' && grid[n-1][n-2] == '1' && grid[n-2][n-1] == '0') {
    			out.println(2);
    			out.println((0+1) + " " + (1+1));
    			out.println((n-2+1) + " " + (n-1+1));
    		}else if(grid[0][1] == '0' && grid[1][0] == '1' && grid[n-1][n-2] == '0' && grid[n-2][n-1] == '1') {
    			out.println(2);
    			out.println((0+1) + " " + (1+1));
    			out.println((n-2+1) + " " + (n-1+1));
    		}else if(grid[0][1] == '1' && grid[1][0] == '0' && grid[n-1][n-2] == '0' && grid[n-2][n-1] == '1') {
    			out.println(2);
    			out.println((0+1) + " " + (1+1));
    			out.println((n-1+1) + " " + (n-2+1));
    		}else if(grid[0][1] == '0' && grid[1][0] == '1' && grid[n-1][n-2] == '1' && grid[n-2][n-1] == '0') {
    			out.println(2);
    			out.println((1+1) + " " + (0+1));
    			out.println((n-2+1) + " " + (n-1+1));
    		}else if(grid[0][1] == '1' && grid[1][0] == '1' && grid[n-1][n-2] == '1' && grid[n-2][n-1] == '1') {
    			out.println(2);
    			out.println((n-1+1) + " " + (n-2+1));
    			out.println((n-2+1) + " " + (n-1+1));
    		}else if(grid[0][1] == '1' && grid[1][0] == '1' && grid[n-1][n-2] == '1' && grid[n-2][n-1] == '0') {
    			out.println(1);
    			out.println((n-1+1) + " " + (n-2+1));
    		}else if(grid[0][1] == '0' && grid[1][0] == '1' && grid[n-1][n-2] == '1' && grid[n-2][n-1] == '1') {
    			out.println(1);
    			out.println((1+1) + " " + (0+1));
    		}else if(grid[0][1] == '1' && grid[1][0] == '1' && grid[n-1][n-2] == '0' && grid[n-2][n-1] == '1') {
    			out.println(1);
    			out.println((n-2+1) + " " + (n-1+1));
    		}else if(grid[0][1] == '1' && grid[1][0] == '0' && grid[n-1][n-2] == '1' && grid[n-2][n-1] == '1') {
    			out.println(1);
    			out.println((0+1) + " " + (1+1));
    		}else if(grid[0][1] == '0' && grid[1][0] == '0' && grid[n-1][n-2] == '0' && grid[n-2][n-1] == '1') {
    			out.println(1);
    			out.println((n-1+1) + " " + (n-2+1));
    		}else if(grid[0][1] == '0' && grid[1][0] == '0' && grid[n-1][n-2] == '1' && grid[n-2][n-1] == '0') {
    			out.println(1);
    			out.println((n-2+1) + " " + (n-1+1));
    		}else if(grid[0][1] == '1' && grid[1][0] == '0' && grid[n-1][n-2] == '0' && grid[n-2][n-1] == '0') {
    			out.println(1);
    			out.println((1+1) + " " + (0+1));
    		}else if(grid[0][1] == '0' && grid[1][0] == '1' && grid[n-1][n-2] == '0' && grid[n-2][n-1] == '0') {
    			out.println(1);
    			out.println((0+1) + " " + (1+1));
    		}else{
    			out.println(0);
    		}
    		
    	}
    	out.close(); 
    }    	  	
    

    
    static int gcd(int a, int b) {
    	if(b==0) return a;
    	return gcd(b, a%b);
    }
    
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}