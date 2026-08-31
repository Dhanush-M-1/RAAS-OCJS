import java.util.*;
import java.util.Collections;

import org.omg.CORBA.BAD_INV_ORDER;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    int[] C = new int[N - 1];
    int total = 0;

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    for (int i = 0; i < N; i++) {
      total += sc.nextInt();
    }
    for (int i = 0; i < N - 1; i++) {
      C[i] = sc.nextInt();
    }
    for (int i = 1; i < N; i++) {
      if (A[i] - 1 == A[i - 1]) {
        total += C[A[i - 1] - 1];
      }
    }
    System.out.println(total);
  }
}
