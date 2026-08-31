import java.util.*;
import java.io.*;
import java.math.*;

public class CP{





  public static OutputStream out=new BufferedOutputStream(System.out);
  static Scanner sc=new Scanner(System.in);
  static long MOD=998244353l;
  static int INF=10000000;
  static long[] fact;
  static long[] inv_fact;
  static int[] rr=new int[]{1, 0, -1, 0};                                 //rook row move
  static int[] rc=new int[]{0, 1, 0, -1};                                 //rook col move

  //nl-->neew line; //l-->line;  //arp-->array print;  //arpnl-->array print new line
  public static void nl(Object o) throws IOException{out.write((o+"\n").getBytes()); }
  public static void l(Object o) throws IOException{out.write((o+"").getBytes());}
  public static void arp(int[] o) throws IOException{for(int i=0;i<o.length;i++) out.write((o[i]+" ").getBytes()); out.write(("\n").getBytes());}
  public static void arpnl(int[] o) throws IOException{for(int i=0;i<o.length;i++) out.write((o[i]+"\n").getBytes());}
  public static void scanl(long[] a,int n) {for(int i=0;i<n;i++) a[i]=sc.nextLong();}
  public static void scani(int[] a,int n) {for(int i=0;i<n;i++) a[i]=sc.nextInt();}
  public static void scan2D(int[][] a,int n,int m) {for(int i=0;i<n;i++) for(int j=0;j<m;j++) a[i][j]=sc.nextInt();}
  //static variables

  //


  public static void main(String[] args) throws IOException{
    long sttm=System.currentTimeMillis();

    int t=1;
    t=sc.nextInt();
    while(t-->0) solve();

    out.flush();
  }

  public static void solve() throws IOException{
      int n=sc.nextInt();
      char[][] a=new char[n][n];
      for(int i=0;i<n;i++){
          char[] c=sc.next().toCharArray();
          for(int j=0;j<n;j++){
              a[i][j]=c[j];
          }
      }
      ArrayList<Pair> arrl=new ArrayList<Pair>();
      if(a[0][1]==a[1][0] && a[n-1][n-2]==a[n-2][n-1]){
          if(a[0][1]==a[n-1][n-2]){
              arrl.add(new Pair(1, 2));
              arrl.add(new Pair(2, 1));
          }
      }
      else if(a[0][1]==a[1][0] || a[n-1][n-2]==a[n-2][n-1]){
          if(a[0][1]==a[1][0]){
              if(a[0][1]==a[n-1][n-2]){
                  arrl.add(new Pair(n, n-1));
              }
              else{
                  arrl.add(new Pair(n-1, n));
              }
          }
          else{
              if(a[0][1]==a[n-1][n-2]){
                  arrl.add(new Pair(1, 2));
              }
              else{
                  arrl.add(new Pair(2, 1));
              }
          }
      }
      else{
          if(a[0][1]==a[n-1][n-2]){
              arrl.add(new Pair(1, 2));
              arrl.add(new Pair(n-1, n));
          }
          else{
              arrl.add(new Pair(1, 2));
              arrl.add(new Pair(n, n-1));
          }
      }
      nl(arrl.size());
      for(Pair p:arrl){
          nl(p.x+" "+p.y);
      }
  }

  static long gcd(long a, long b)
	{
	if (b == 0)
		return a;
	return gcd(b, a % b);
  }

}

class Pair{
  int x; int y;
  Pair(int x,int y){
    this.x=x;
    this.y=y;
  }
}
