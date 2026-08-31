import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) throws IOException {
    InputScanner scanner = new InputScanner();
    while (scanner.hasNext()) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      int[] weights = scanner.nextInts(n);
      int[] order = scanner.nextInts(m);
      boolean[] visited = new boolean[n];
      Arrays.fill(visited, false);
      Deque<Integer> currentOrder = new LinkedList<>();
      IntStream.range(0, m).forEach((e) -> {
        order[e]--;
        if (!visited[order[e]]) {
          visited[order[e]] = true;
          currentOrder.add(order[e]);
        }
      });
      long sum = 0;
      for (int i = 0; i < m; i++) {
        int p = order[i];
        for (Iterator<Integer> iter = currentOrder.iterator(); iter.hasNext();) {
          int e = iter.next();
          if (e == p) {
            iter.remove();
            break;
          } else {
            sum += weights[e];
          }
        }
        currentOrder.addFirst(p);
      }
      System.out.println(sum);
    }
  }
}

class InputScanner {
  private final Scanner scanner;

  public InputScanner() {
    this(System.in);
  }

  public InputScanner(String file) throws FileNotFoundException {
    this(new File(file));
  }

  public InputScanner(File file) throws FileNotFoundException {
    this(new FileInputStream(file));
  }

  public InputScanner(InputStream inputStream) {
    scanner = new Scanner(new BufferedInputStream(inputStream));
  }

  public boolean hasNext() {
    return scanner.hasNext();
  }

  public int nextInt() {
    return scanner.nextInt();
  }

  public int[] nextInts(int n) {
    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = nextInt();
    }
    return input;
  }

  public String next() {
    return scanner.next();
  }

  @Override
  protected void finalize() throws Throwable {
    scanner.close();
    super.finalize();
  }
}