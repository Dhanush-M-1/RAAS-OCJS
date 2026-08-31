import java.util.*;
 
public class Main {
 
	static Main instance = new Main();
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] a = new long[N];
        long[] b = new long[N];
        long[] c = new long[M];
        long[] d = new long[M];
        
        for(int i = 0; i < N; i++){
          a[i] = sc.nextLong();
          b[i] = sc.nextLong();
        }
      
        for(int i = 0; i < M; i++){
          c[i] = sc.nextLong();
          d[i] = sc.nextLong();
        }
        
        for(int i = 0; i < N; i++){
          long ans = 0;
          long min = Long.MAX_VALUE;
          for(int j = 0; j < M; j++){
            long manhattan = Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
              if(manhattan < min){
                min = manhattan;
                ans = j;
              }
          }
          
          System.out.println(ans+1);
        }
         
	}
}