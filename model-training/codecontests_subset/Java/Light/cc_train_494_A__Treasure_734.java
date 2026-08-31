import java.io.*;
import java.util.*;

public class R282_Div2_C {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		String s = readString();
      
      int open = 0;
      int count = 0;
      int after = 0;
      for(int p = 0; p < s.length(); ++p) {
         if(s.charAt(p) == '(') {
            ++open;
            ++after;
         } else {
            --open;
            if(after > 0)
               --after;
            if(s.charAt(p) == '#') {
               ++count;
               after = 0;
            }
         }
         if(open < 0) {
            System.out.println(-1);
            return;
         }
      }
      
      if(after > 0 || (open > 0 && count == 0)) {
         System.out.println(-1);
         return;
      }
      for(int i = 0; i < count-1; ++i)
         System.out.println(1);
      System.out.println(open+1);
	}

	static String readString() throws Exception {
		while(!st.hasMoreTokens())
			st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}
	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
	static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
}
