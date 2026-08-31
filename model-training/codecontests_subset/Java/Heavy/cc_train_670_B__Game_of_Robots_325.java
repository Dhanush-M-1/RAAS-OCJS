import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class MyClass {
 
  void solve() {
	int n=readInt();
	int k=readInt();
	int i;
	String[]id=new String[n];
	for(i=0;i<n;i++) {
		id[i]=readString();
	}
	int s=1,j=2;
	while(k>s) {
		s+=j;
		j++;
	}
	out.print(id[k-2+j-s]);
  }
 
  public static void main(String[] args) {
    new MyClass().run();
  }
 
  public void run() {
    try {
      init();
      solve();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
  BufferedReader in;
  StringTokenizer tok = new StringTokenizer("");
  PrintWriter out;
 
  void init() {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
  }
 
  String readString() {
    while (!tok.hasMoreTokens()) {
      try {
        tok = new StringTokenizer(in.readLine());
      } catch (Exception e) {
        return null;
      }
    }
    return tok.nextToken();
  }
 
  int readInt() {
    return Integer.parseInt(readString());
  }
 
  long readLong() {
    return Long.parseLong(readString());
  }
}