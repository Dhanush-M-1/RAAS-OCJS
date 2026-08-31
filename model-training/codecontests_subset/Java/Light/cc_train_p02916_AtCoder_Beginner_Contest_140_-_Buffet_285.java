import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int[] A = new int[N+1];
    int[] B = new int[N+1];
    int[] C = new int[N];
    
    for (int i=1; i<N+1; i++) {
      A[i] = scan.nextInt();
    }
    
    for (int i=1; i<N+1; i++) {
      B[i] = scan.nextInt();
    }
    
    for (int i=1; i<N; i++) {
      C[i] = scan.nextInt();
    }
   
    int sum= 0;
    
    for (int j=1; j<N+1; j++){
      sum += B[A[j]];
      if (A[j]-A[j-1] ==1 && j!=1) {
        sum += C[A[j-1]];
      }
    }
 
    System.out.println(sum);
  
  }
 
}