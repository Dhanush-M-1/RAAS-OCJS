import java.util.Scanner;

public class FakeNP{
  public static void main(String[] args){
    Scanner scr = new Scanner(System.in);
    
    int a = scr.nextInt();
    int b = scr.nextInt();
    if(a==b){
      System.out.println(a);
    }
    else if (a%3==0 && b-a==3){
      System.out.println('3');
    }
    else{
        System.out.println('2');
      }
    
    
  }
}