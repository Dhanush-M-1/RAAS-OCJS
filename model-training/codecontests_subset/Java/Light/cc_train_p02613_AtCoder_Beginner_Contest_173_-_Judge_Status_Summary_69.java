import java.util.*;

class Main{
  public static void main(String args[]){
    Scanner scan=new Scanner(System.in);
    int ac=0, wa=0, tle=0, re=0;
    int num=scan.nextInt();
    for(int a=0; a<num; a++){
      String in=scan.next();
      switch(in){
        case "AC":
          ac++;
          break;
        case "WA":
          wa++;
          break;
        case "TLE":
          tle++;
          break;
        case "RE":
          re++;
          break;
      }
    }
    System.out.println("AC x "+ac);
    System.out.println("WA x "+wa);
    System.out.println("TLE x "+tle);
    System.out.println("RE x "+re);
  }
}