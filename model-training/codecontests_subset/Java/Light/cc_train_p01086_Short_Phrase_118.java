import java.util.*;

class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      int n = sc.nextInt();
      if (n == 0) return;
      String s[] = new String[n];
      for (int i = 0; i < n; i++)
        s[i] = sc.next();

      int c[] = {5, 7, 5, 7, 7};
      int cn = 0;
      int count = 0;
      loop: for (int i = 0; i <= n-5; i++) {
        for (int j = i; j < n; j++) {
          count += s[j].length();
          if (count == c[cn]) {
            cn++;
            count = 0;
            if (cn == 5){
              System.out.println(i + 1);
              break loop;
            }
          }
          else if (count > c[cn]) {
            cn = 0;
            count = 0;
            break;
          }
        }
      }
    }
  }
}

