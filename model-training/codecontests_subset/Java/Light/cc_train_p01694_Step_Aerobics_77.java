import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  Scanner sc;

  class Pair {
    int f;
    int s;

    Pair(int f_, int s_) {
      f = f_;
      s = s_;
    }
  }

  void run() {
    for ( ;; ) {
      int n = ni();

      if ( n == 0 ) {
        break;
      }

      HashMap<String, Pair> map = new HashMap<String, Pair>();

      map.put( "lu", new Pair( 1, 0 ) );
      map.put( "ru", new Pair( 0, 1 ) );
      map.put( "ld", new Pair( -1, 0 ) );
      map.put( "rd", new Pair( 0, -1 ) );

      int cnt = 0;
      int state = 0;
      Pair p = new Pair( 0, 0 );
      for ( int i = 0; i < n; ++i ) {
        String str = sc.next();
        Pair ofs = map.get( str );
        p.f += ofs.f;
        p.s += ofs.s;
        //debug(p.f, p.s);
        if ( p.f == p.s  && 1 - state == p.f) {
          ++cnt;
          state = 1 - state;
        }
      }

      System.out.println( cnt );
    }
  }

  Main() {
    sc = new Scanner( System.in );
  }

  int ni() {
    return sc.nextInt();
  }

  public static void main(String[] args) {
    new Main().run();
  }

  void debug(Object... os) {
    System.err.println( Arrays.deepToString( os ) );
  }
}