import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Santa.
 */
public class Main {

  static int N;
  static int K;
  static long Q;
  static int A;
  static long B;
  static long C;
  static double min = 9999999;
  static long ans = 0;




  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);


    String s = scanner.nextLine();

    boolean ans = false;
    int N = s.length();
//    System.out.println(N);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        String temps = s.substring(0,i) + s.substring(j + 1, N);
        if(temps.equals("keyence"))ans = true;
//        System.out.println(temps);
      }

    }

    if(ans){
      System.out.println("YES");
    }else{
      System.out.println("NO");
    }


  }

}
