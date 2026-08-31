import java.util.*;
public class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    if((1 & scn.nextInt() & scn.nextInt()) == 1){
      System.out.println("Odd");
    } else {
      System.out.println("Even");
    }
  }
}