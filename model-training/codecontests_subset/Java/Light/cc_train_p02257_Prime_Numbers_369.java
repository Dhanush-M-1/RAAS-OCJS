import java.util.*;
import java.io.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.Math.*;

public class Main {

  public static boolean is_prime(int k) {
    for (int i=2; i*i<=k; i++) 
    if (k%i == 0) return false;
    return k != 1;
  }

  public static void main(String[] args) {
    int i;
    int res = 0;
    Scanner sc = new Scanner(System.in); 
    int n = Integer.parseInt(sc.next());;
    for (i=0; i<n; i++) {
      int a = Integer.parseInt(sc.next());;
      if (is_prime(a)) res++;
    }
    System.out.println(res);
  }
}