import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out);

    while (true) {
      int h = sc.nextInt();
      int w = sc.nextInt();

      if (h == 0 && w == 0) break;

      IntStream.range(0, h).forEach(i -> {
        IntStream.range(0, w).forEach(j -> {
          pw.print((i + j) % 2 == 0 ? "#" : ".");
        });
        pw.println();
      });
      pw.println();
    }
    pw.flush();
  }
}
