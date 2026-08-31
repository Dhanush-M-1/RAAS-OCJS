import java.util.Scanner;

public class SeeFootball implements Runnable {
  public void run() {
    try {
      Scanner in = new Scanner(System.in);
      //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      System.out.println((c * (a - b) + b - 1) / b);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    new Thread(new SeeFootball()).start();
  }
}
