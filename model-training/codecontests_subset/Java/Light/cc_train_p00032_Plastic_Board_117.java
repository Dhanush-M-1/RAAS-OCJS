import java.util.*;
class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int counterR = 0, counterD = 0;
    while(sc.hasNext()) {
      String str = sc.next();
      String[] strArr = str.split(",");
      int a = Integer.parseInt(strArr[0]);
      int b = Integer.parseInt(strArr[1]);
      int c = Integer.parseInt(strArr[2]);
      if (a*a+b*b == c*c) {
        counterR++;
      }
      else if (a == b) {
        counterD++;
      }
    }
    System.out.println(counterR);
    System.out.println(counterD);
  }
}