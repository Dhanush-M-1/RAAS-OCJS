import java.io.*;
import java.util.*;

public class ReverseSubstring {
	static BufferedReader br ;
	static StringTokenizer st;
	static PrintWriter out;
	
	static String next() throws Exception{
		while(st == null || !st.hasMoreElements() ) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
	
	static long nextLong() throws Exception{
		return Long.parseLong(next());
	}
	
	static int nextInt() throws Exception{
		return Integer.parseInt(next());
	}
	
	static String nextLine() throws Exception{
			return br.readLine();
	}
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

    int n= nextInt();
    String s = nextLine();
    int pos = 0 , min=0;
    for(int i=1; i<n; i++){
      if(s.charAt(i-1)>s.charAt(i)){
        min = i;
        pos = i+1;
        break;
      }
    }
    if(min == pos)out.println("NO");
    else{
      out.println("YES");
      out.println(min+" "+pos);
    }
		out.close();
		br.close();
	}
}
