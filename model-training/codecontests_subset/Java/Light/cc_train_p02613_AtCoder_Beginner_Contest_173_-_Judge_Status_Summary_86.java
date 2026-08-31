import java.util.*;

public class Main{
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N=sc.nextInt(),cAC=0, cRE=0, cTLE=0, cWA=0;
    String a;
    for(int i=0; i<N; i++) {
      a=sc.next();
      switch(a) {
        case "AC":
          cAC++;
          break;
        case "WA":
          cWA++;
          break;
        case "TLE":
          cTLE++;
          break;
        case "RE":
          cRE++;
          break;
      }
    }
    System.out.println("AC x " + cAC);
    System.out.println("WA x " + cWA);
    System.out.println("TLE x " + cTLE);
    System.out.println("RE x " + cRE);

  }
}