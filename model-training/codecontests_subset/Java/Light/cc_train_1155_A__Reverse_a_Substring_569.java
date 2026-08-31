
// Reverse a Substring - codeforces
// wrong answer

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    char[] s = sc.nextLine().toCharArray();
    int a = 0;
    int i = 0;
    while (a < n - 1 && s[a + 1] >= s[a]) {
      a++;
    }
    if (a == n - 1) {
      System.out.println("NO");
      System.exit(0);
    }
    i = a;
    while (i < n - 1 && s[i + 1] <= s[i]) {
      i++;
    }
    //System.out.println(i);
    System.out.println("YES");
    a++;
    i++;
    System.out.println(a + " " + i);

  }
}
