import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a1 = sc.nextInt();
    int a2 = sc.nextInt();
    if ((a1>9)||(a2>9)){
      System.out.println(-1);
    }else{
    System.out.println(a1*a2);
    }
  }    
}