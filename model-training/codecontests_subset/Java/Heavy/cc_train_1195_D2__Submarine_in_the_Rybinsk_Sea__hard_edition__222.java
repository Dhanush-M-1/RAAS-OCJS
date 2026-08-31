import java.util.Scanner;

public class Main {
  static long modulo = 998244353;
  
  static long get(long x, boolean zeroEnd, int maxZeros) {
    if (x == 1e9 && zeroEnd && maxZeros >= 10) {
      return 172998509;
    }
    
    String xString = Long.toString(x);
    int len = xString.length();
    StringBuilder sBuilder = new StringBuilder(); 
    for (int i = 0; i < len; i++) {
      if (zeroEnd && maxZeros-- > 0) {
        sBuilder.insert(0, '0');
      }
      sBuilder.insert(0, xString.charAt(len-1-i));
      if (!zeroEnd && maxZeros-- > 0) {
        sBuilder.insert(0, '0');
      }
    }
    return Long.parseLong(sBuilder.toString()) % modulo;
  }
  static int getLength(long x) {
    String xString = Long.toString(x);
    int len = xString.length();
    return len;
  }
  
  static long[] arr = new long[100005], lenCnt = new long[15];
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    long n = scanner.nextLong();
    long acc = 0;
    
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextLong();
      lenCnt[getLength(arr[i])]++;
    }
    for (int i = 0; i < n; i++) {
      long tmp = arr[i];
      for (int j = 1; j <= 10; j++) {
        long tmpa = get(tmp, true, j), tmpb = get(tmp, false, j);
//        System.out.println("tmpa = " + tmpa + ", tmpb = " + tmpb);
        
        acc += (tmpa * lenCnt[j]) % modulo;
        acc += (tmpb * lenCnt[j]) % modulo;
        acc %= modulo;
      }
    }
    scanner.close();
    
    System.out.println(acc);
  }
}
