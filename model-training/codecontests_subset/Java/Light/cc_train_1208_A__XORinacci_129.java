import java.util.*;

public class Practise {
    static Scanner in = new Scanner(System.in);

    static void solve() {
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        int c = a ^ b;

        if(n % 3 == 0) System.out.println(a);
        else if(n % 3 == 1) System.out.println(b);
        else System.out.println(c);

    }

    public static void main(String[] args) {

      int t = in.nextInt();

      while(t-- > 0) {
          solve();
      }



    }

}



