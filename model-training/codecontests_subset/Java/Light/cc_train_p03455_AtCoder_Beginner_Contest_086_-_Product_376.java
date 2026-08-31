import java.util.*;
public class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();
    int y = scn.nextInt();
    if(x * y % 2 == 0){
      System.out.println("Even");
    } else {
      System.out.println("Odd");
    }
  }
}