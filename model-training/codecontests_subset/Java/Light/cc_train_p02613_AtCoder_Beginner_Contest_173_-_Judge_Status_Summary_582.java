import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int ac = 0;
    int wa = 0;
    int tle = 0;
    int re = 0;
    for(int i = 0;i < num;i++){
      String line = sc.next();
      if(line.equals("AC")){
        ac++;
      }
      else if(line.equals("WA")){
        wa++;
      }
      else if(line.equals("TLE")){
        tle++;
      }
      else{
        re++;
      }
    }
    System.out.println("AC x " + ac + "\nWA x " + wa + "\nTLE x " + tle + "\nRE x " + re);
  }
}