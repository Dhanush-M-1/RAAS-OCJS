import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception{
    try (Scanner sc = new Scanner(System.in)){
      int N = sc.nextInt();
      int sum = 0;
      for (int i = 0; i < N; i++) {
        sum += sc.nextInt();
      }
      System.out.println(sum - N);
    }
  }
}