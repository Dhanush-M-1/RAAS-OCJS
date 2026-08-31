import java.util.Scanner;

public class Solution {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a = 0, b = 0;
    for (char c : in.next().toCharArray())
      if (c == 'A')
        a++;
      else if (c == 'I')
        b++;
    System.out.println(b == 1 ? 1 : b == 0 ? a : 0);
  }

}
