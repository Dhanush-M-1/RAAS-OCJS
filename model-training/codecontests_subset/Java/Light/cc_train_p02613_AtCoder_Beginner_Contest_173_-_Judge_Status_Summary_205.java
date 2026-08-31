import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cntAC = 0;
    int cntWA = 0;
    int cntTLE = 0;
    int cntRE = 0;
    int n = sc.nextInt();
    for(int i = 0; i < n; i++){
      String type = sc.next();
      if("AC".equals(type)) cntAC++;
      if("WA".equals(type)) cntWA++;
      if("TLE".equals(type)) cntTLE++;
      if("RE".equals(type)) cntRE++;

    }
    System.out.println("AC x " + cntAC);
    System.out.println("WA x " + cntWA);
    System.out.println("TLE x " + cntTLE);
    System.out.println("RE x " + cntRE);
  }
}
