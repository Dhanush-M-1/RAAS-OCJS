import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.next());
    int A[] = new int[N];
    int B[] = new int[N];
    int C[] = new int[N-1];
    
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i < N; i++) {
      B[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i < N-1; i++) {
      C[i] = Integer.parseInt(sc.next());
    }
    
    int sum = B[A[0]-1];
    for (int i = 1; i < N; i++) {
      sum += B[A[i]-1];
      if (A[i] == A[i-1] + 1) {
        sum += C[A[i-1]-1];
      }
    }
    
    System.out.println(sum);
  }
}