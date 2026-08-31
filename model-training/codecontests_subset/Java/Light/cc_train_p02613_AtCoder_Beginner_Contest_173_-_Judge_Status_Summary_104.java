import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int a1 = 0;
    int a2 = 0;
    int a3 = 0;
    int a4 = 0;
    for (int i=0;i<n;i++){
      String g = scan.next();
      if (g.equals("AC")){
        a1 += 1;
      }

      if (g.equals("WA")){
        a2 += 1;
      }

      if (g.equals("TLE")){
        a3 += 1;
      }

      if (g.equals("RE")){
        a4 += 1;
      }
    }

    System.out.println("AC x "+a1);
    System.out.println("WA x "+a2);
    System.out.println("TLE x "+a3);
    System.out.println("RE x "+a4);
  }
}
