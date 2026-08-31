import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String X = sc.next();
    Deque<Character> stack = new ArrayDeque<>(); // スタック
    for (int i = 0; i < X.length(); i++) {
      if (X.charAt(i) == 'S') { // i番目がS
        stack.push(X.charAt(i));
      } else { // i番目がT
        if (stack.size() == 0) { // スタックが空
          stack.push(X.charAt(i));
        } else if (stack.peek() == 'S') { // i-1番目がS
          stack.pop();
        } else if (stack.peek() == 'T') { // i-1番目がT
          stack.push(X.charAt(i));
        }
      }
    }
    System.out.println(stack.size());
  }
}