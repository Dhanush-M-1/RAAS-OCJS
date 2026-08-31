public class Main {
  public static void main(String[] args) {
    try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
      StringBuilder sb = new StringBuilder();
      char[] a = sc.next().toCharArray();
      int i = 0;
      java.util.Deque<Character> stack = new java.util.ArrayDeque<>();
      while (i != a.length) {
        stack.push(a[i]);
        while (++i != a.length && a[i] == 'T' && !stack.isEmpty() && stack.peek() == 'S') {
          stack.pop();
        }
      }
      System.out.println(stack.size());
    } // end try
  } // end main()
} // end Solution
