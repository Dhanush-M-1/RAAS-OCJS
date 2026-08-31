import java.util.Scanner;
public class Main {
  public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   int ac=0,wa=0,tle=0,re=0;
   for(int i=0;i<n;i++){
    switch(sc.next()){
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
      default:
        break;
    }
   }

   System.out.println("AC x "+ac);
   System.out.println("WA x "+wa);
   System.out.println("TLE x "+tle);
   System.out.println("RE x "+re);
  }
}