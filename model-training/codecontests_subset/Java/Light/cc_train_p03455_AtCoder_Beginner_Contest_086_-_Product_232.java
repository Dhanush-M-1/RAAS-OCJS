import java.util.*;

class Main{
  public static void main(String[] s){
  	Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    
    if(a%2==1 && b%2==1)
      System.out.println("Odd");
    else
      System.out.println("Even");
  }
}
