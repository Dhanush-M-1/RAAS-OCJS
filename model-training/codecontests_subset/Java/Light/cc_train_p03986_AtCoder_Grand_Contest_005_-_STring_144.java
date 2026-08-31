import java.util.*;
public class Main {
  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int scnt = 0;
     int tcnt = 0;
     String X = sc.next();
     for (int i = 0 ; i < X.length(); i++) {
        if (X.charAt(i) == 'S') {
          scnt++;
        } else if (scnt > 0 && X.charAt(i) == 'T') {
          scnt--;
        } else {
          tcnt++;
        }
     }
     System.out.println(scnt + tcnt);
  }
}
