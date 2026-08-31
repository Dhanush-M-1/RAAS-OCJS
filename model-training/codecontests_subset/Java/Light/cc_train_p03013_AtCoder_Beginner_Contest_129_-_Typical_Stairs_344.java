import java.util.*;
public class Main {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    Map<Integer, Long> memo = new HashMap<>();
    Set<Integer> broken = new HashSet<>();
    int[] a = new int[M];
    for (int i = 0; i < M; i++) {
      broken.add(sc.nextInt());
    }
    
    long ans = func(0, N, broken, memo);
    
    System.out.println(ans);
  }
  
  private static long func(int n, int N, Set<Integer> broken,
                          Map<Integer, Long> memo) {

    if (broken.contains(n) || N < n) {
      return 0;
    }
    if (n == N) {
      return 1;
    }
    Long cache = memo.get(n);
    if (cache != null) {
      return cache;
    }
    
    long value = func(n+1, N, broken, memo) % 1000000007
      + func(n+2, N, broken, memo) % 1000000007;
    memo.put(n, value % 1000000007);

    return value % 1000000007;
  }
}