import java.util.*;
public class Main {
  public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long ac = 0;
    long wa = 0;
    long tle = 0;
    long re = 0;
    String tmp = "";
    for(int i=0;i<n;i++){
      tmp = sc.next();
      if( tmp.equals("AC") ){
        ac++;
      }else if(tmp.equals("WA") ){
        wa++;
      }else if(tmp.equals("TLE")){
        tle++;
      }else if( tmp.equals("RE")){
        re++;
      }
    }
    System.out.println("AC x "+ac);
    System.out.println("WA x "+wa);
    System.out.println("TLE x "+tle);
    System.out.println("RE x "+re);
  }
}