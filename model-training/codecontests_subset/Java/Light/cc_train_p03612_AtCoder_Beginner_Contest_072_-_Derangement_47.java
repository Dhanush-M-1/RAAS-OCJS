import java.io.*;
import java.util.*;

class Main
{
  static int[] A;
  
  static boolean isValid() //check if the current array needs swaps or doesn't need swaps:
  {
    for (int i = 0; i < A.length; i++)
    {
      if (A[i] == i + 1)
      {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    A = new int[N];
    for (int i = 0; i < N; i++)
    {
      A[i] = sc.nextInt();
    }
    int swaps = 0;
    while (!isValid())
    {
      //look through all elements through 1 to N - 1:
      for (int i = 0; i < A.length - 1; i++)
      {
        if (A[i] == i + 1) //xx or xo
        {
          swaps += 1;
          //swap A[i] and A[i + 1]:
          int temp = A[i];
          A[i] = A[i + 1];
          A[i + 1] = temp;
        }
      }
      if (A[N - 1] == N) //ox
      {
        swaps += 1;
        int temp = A[N - 1];
        A[N - 1] = A[N - 2];
        A[N - 2] = temp;
      }
    }
    System.out.println(swaps);
  }
}
