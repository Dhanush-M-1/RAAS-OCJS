
//Omar brome, lcpc practice, codeforces: *aAndBandCompilationErrors
//basic code for fast java input/output learned from kattis

import java.util.*;
import java.io.*;

public class Main{
public static void main(String[] args){
Kattio tuna= new Kattio(System.in,System.out);
int n= tuna.getInt(); 
long A=0L;
for (int a=0; a<n;a++) {
  A+=tuna.getInt();
}
long B=0L;
for (int b=0; b<n-1;b++) {
  B+=tuna.getInt();
}
long C=0L;
for (int c=0; c<n-2;c++) {
  C+=tuna.getInt();
}
tuna.println(A-B);
tuna.println(B-C);
tuna.flush();
}
}

class Kattio extends PrintWriter {
  public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
  }
  public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
  }

  public boolean hasMoreTokens() {
    return peekToken() != null;
  }

  public int getInt() {
    return Integer.parseInt(nextToken());
  }

  public double getDouble() { 
    return Double.parseDouble(nextToken());
  }

  public long getLong() {
    return Long.parseLong(nextToken());
  }

  public String getWord() {
    return nextToken();
  }



  private BufferedReader r;
  private String line;
  private StringTokenizer st;
  private String token;

  private String peekToken() {
    if (token == null) 
        try {
        while (st == null || !st.hasMoreTokens()) {
            line = r.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        token = st.nextToken();
        } catch (IOException e) { }
    return token;
  }

  private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
  }
}
