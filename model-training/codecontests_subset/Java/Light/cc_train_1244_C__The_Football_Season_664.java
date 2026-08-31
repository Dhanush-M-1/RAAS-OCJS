import java.io.IOException;
import java.math.BigInteger;

public class Main implements Runnable {
  static String readLn(int maxLength) {

    byte line[] = new byte[maxLength];
    int length = 0;
    int input = -1;
    try {
      while (length < maxLength) {
        input = System.in.read();
        if ((input < 0) || (input == '\n')) {
          break;
        }

        line[length++] += input;
      }

      if ((input < 0) && (length == 0)) {
        return null;
      }

      return new String(line, 0, length).trim();
    } catch (IOException e) {
      return null;
    }
  }

  public static void main(String args[]) {
    Main myWork = new Main();
    myWork.run();
  }

  public void run() {
    new TheFootballSeason().run();
  }
}


class TheFootballSeason implements Runnable {
  @Override
  public void run() {
    String line = Main.readLn(100);
    String[] numbers = line.split(" ");
    long n = Long.parseLong(numbers[0]);
    long p = Long.parseLong(numbers[1]);
    long w = Long.parseLong(numbers[2]);
    long d = Long.parseLong(numbers[3]);

    for(long y = 0; y <= w - 1; y++) {
      long pDiff = p - d * y;
      if(pDiff >= 0 && pDiff % w == 0 && pDiff / w + y <= n) {
        System.out.printf("%d %d %d", pDiff / w, y, n - pDiff / w - y);
        return;
      }
    }

    System.out.println(-1);
  }

  static long gcd(long p, long q) {
    if (q == 0)
      return p;

    return gcd(q, p % q);
  }
}