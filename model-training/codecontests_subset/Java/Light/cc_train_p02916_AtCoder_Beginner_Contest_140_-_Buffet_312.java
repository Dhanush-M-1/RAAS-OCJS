import java.util.*;

public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.next());
    int[] A = new int[N+1];
    int[] B = new int[N+1];
    int[] C = new int[N];
    for(int i = 1; i <= N; i++){
      A[i] = Integer.parseInt(sc.next());
    }
    for(int i = 1; i <= N; i++){
      B[i] = Integer.parseInt(sc.next());
    }
    for(int i = 1; i <= N-1; i++){
      C[i] = Integer.parseInt(sc.next());
    }
    
    int sum = 0;
    int bef = -1;
    for(int i = 1; i <= N; i++){
      int n = A[i];
      sum += B[n];
      if(bef+1 == n){
        sum += C[bef];
      }
      bef = n;
    }
    System.out.println(sum);
  }
}