import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int ac = 0;
    int wa = 0;
    int tle = 0;
    int re = 0;
    for(int i = 0; i <= n; ++i) {
      String curr = in.nextLine();
      if(curr.equals("AC")) ++ac;
      if(curr.equals("WA")) ++wa;
      if(curr.equals("TLE")) ++tle;
      if(curr.equals("RE")) ++re;
    }
    
    System.out.println("AC x " + ac);
    System.out.println("WA x " + wa);
    System.out.println("TLE x " + tle);
    System.out.println("RE x " + re);
  }
}