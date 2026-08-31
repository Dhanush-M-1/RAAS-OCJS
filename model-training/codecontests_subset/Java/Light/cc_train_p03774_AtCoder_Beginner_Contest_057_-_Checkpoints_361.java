import java.util.*;
public class Main {
	public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      long[] a = new long[N];
      long[] b = new long[N];
      long[] c = new long[M];
      long[] d = new long[M];
      for(int i=0;i<N;i++){
        a[i] = sc.nextLong();
        b[i] = sc.nextLong();
      }
      for(int i=0;i<M;i++){
        c[i] = sc.nextLong();
        d[i] = sc.nextLong();
      }
      for(int i=0;i<N;i++){
        long min = 4*100000000+1;
        long ans = 0;
        for(int j=0;j<M;j++){
          long man = (long)Math.abs(a[i]-c[j])+(long)Math.abs(b[i]-d[j]);
          if(man<min){
            min = man;
            ans = j+1;
          }
        }
        System.out.println(ans);
      }
    }
}
