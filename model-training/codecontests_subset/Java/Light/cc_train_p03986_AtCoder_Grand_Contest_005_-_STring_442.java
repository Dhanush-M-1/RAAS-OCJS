import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // TODO 自動生成されたメソッド・スタブ
    Scanner sc = new Scanner(System.in);

    String x = sc.next();

    Deque<String> deque = new ArrayDeque<>();

    for (int i = 0; i < x.length(); i++) {
      if (x.charAt(i) == 'S') {
        deque.push(String.valueOf(x.charAt(i)));
      } else {
        if (deque.peek() != null && deque.peek().equals("S")) {
          deque.pop();
        } else {
          deque.push(String.valueOf(x.charAt(i)));
        }
      }
    }
    System.out.println(deque.size());
  }
}
