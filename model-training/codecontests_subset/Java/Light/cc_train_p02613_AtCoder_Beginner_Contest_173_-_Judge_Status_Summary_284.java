import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    int AC= 0;
    int WA= 0;
    int TLE= 0;
    int RE= 0;
    for(int i = 0; i<n;i++){
      String a= sc.next();
      if(a.equals("AC")){
        AC++;
      }
      if(a.equals("WA")){
        WA++;
      }
      if(a.equals("TLE")){
        TLE++;
      }
      if(a.equals("RE")){
        RE++;
      }
      
    }
    System.out.println("AC x " +AC);
    System.out.println("WA x " +WA);
    System.out.println("TLE x " +TLE);
    System.out.println("RE x " +RE);
  }
}

