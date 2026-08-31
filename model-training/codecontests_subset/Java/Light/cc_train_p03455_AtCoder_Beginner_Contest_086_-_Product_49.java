import java.util.Scanner;
public class Main{
  public static void main(String args[]){
    Scanner scn = new Scanner(System.in);
    if(scn.nextInt() % 2 == 0 || scn.nextInt() % 2 == 0){
      System.out.println("Even");
    } else {
      System.out.println("Odd");
    }
  }
}