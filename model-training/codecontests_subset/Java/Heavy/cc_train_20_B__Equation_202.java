import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution implements Runnable {
  BufferedReader in;
  PrintWriter out;
  StringTokenizer tok = new StringTokenizer("");
  
  @Override
  public void run() {
    try {
      init();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    long time = System.currentTimeMillis();
    try {
      solve();
    } catch (Exception e) {
      e.printStackTrace();
    }
    out.close();
    //System.err.println(System.currentTimeMillis() - time);
  }
  
  private void init() throws FileNotFoundException {
    String file = "";
    if (!file.equals("")) {
      in = new BufferedReader(new FileReader("input.txt"));
      out = new PrintWriter("output.txt");
    } else {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
    }
  }
  
  public static void main(String[] args) {
    new Thread(new Solution()).start();
  }
  
  private String readString() {
    while (!tok.hasMoreTokens()) {
      try {
        tok = new StringTokenizer(in.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return tok.nextToken();
  }
  
  private int readInt() {
    return Integer.parseInt(readString());
  }
  
  int[] counts = new int[1000];
  
  private long readLong() {
    return Long.parseLong(readString());
  }
  
  private void solve() {
    double a = readInt();
    double b = readInt();
    double c = readInt();
    double d = b*b-4*a*c;
    if(a==0 && b==0 && c!=0) {
      out.print(0);
      return;
    }
    if(a==0 && b==0 && c==0) {
      out.print(-1);
      return;
    }
    if(a==0) {
      out.println(1);
      out.print(-c/b);
      return;
    }
    if(d<0) {
      out.print(0);
    } else if(d==0) {
      out.println(1);
      out.print(-b/(2*a));
    } else {
      out.println(2);
      double x1 = (-b+Math.sqrt(d))/(2*a);
      double x2 = (-b-Math.sqrt(d))/(2*a);
      if(x1<x2) {
        out.println(x1);
        out.print(x2);
      } else {
        out.println(x2);
        out.print(x1);
      }
    }
  }
  
  
}