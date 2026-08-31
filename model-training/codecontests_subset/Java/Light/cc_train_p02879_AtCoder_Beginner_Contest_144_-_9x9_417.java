import java.util.*;
class Main{
  public static void main(String args[]){
  Scanner scn = new Scanner(System.in);
  int a = scn.nextInt();
  int b = scn.nextInt();
  if(a < 10 && b < 10){
    System.out.println(a*b);
  }else{
    System.out.println(-1);
  }
}
}