import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main implements Runnable{
		
		static {
			
		}
	
		 public static void main(String[] args) throws IOException {
			new Thread(null , new Main(),"Main", 1<<26).start();
			
		 }
		 
		 
		public void run(){
			try {
			PrintWriter out = new PrintWriter(System.out);
			MyScanner sc = new MyScanner();
			solve(out, sc);
			out.close();
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		void solve(PrintWriter out, MyScanner sc){
			
			int n = sc.nextInt();
			String s = sc.next();
			int f = 0, a = 0, i = 0;
			int len = s.length();
			for(int k = 0 ; k < len ; ++k) {
				if(s.charAt(k) == 'F') ++f;
				else if(s.charAt(k) == 'I') ++i;
				else ++a;
			}
			
			if(i > 1) out.print(0);
			else if(i == 1) out.print(1);
			else out.print(a);
		}





class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
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

    String nextLine(){
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

