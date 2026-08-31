import java.util.*;
class Main{
  public static void main(String[] args){
    Scanner scan=new Scanner(System.in);
    int A=scan.nextInt();
    int B=scan.nextInt();
    if(A>=10||B>=10){
      System.out.println("-1");
    }else{
      System.out.println(A*B);
    }
  }
}