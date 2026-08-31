import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    long a[] = new long[N];
    long b[] = new long[N];
    long c[] = new long[M];
    long d[] = new long[M];
    int ans[] = new int[N];
    for(int i=0;i<N;i++){
      a[i]=sc.nextLong();
      b[i]=sc.nextLong();
    }
    for(int i=0;i<M;i++){
      c[i]=sc.nextLong();
      d[i]=sc.nextLong();
    }
    long tmp = 100000000000L;
    for(int i=0;i<N;i++){
      tmp = 100000000000L;
      for(int j=0;j<M;j++){
        if(tmp>(Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]))){
          ans[i]=j+1;
          tmp=Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
        }
      }
    }
    for(int i=0;i<N;i++){
      System.out.println(ans[i]);
    }
  }
  

  
}