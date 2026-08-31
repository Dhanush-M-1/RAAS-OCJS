import java.util.*;

public class Main {

  public static void main(String args[]) {
    (new Main()).solve();
  }

  void solve() {

    Scanner cin = new Scanner(System.in);

    while( cin.hasNextInt() ) {

      int k = cin.nextInt();

      for(int i=1; i<k; ++i) {
        for(int j=1; j<k; ++j) {
          System.out.print(Integer.toString(i * j, k) + " ");
        }
        System.out.println();
      }

    }

  }

}
