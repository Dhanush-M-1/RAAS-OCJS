import java.util.Scanner;

public class HelloWorld {

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int k = sc.nextInt();
    
    int maxDev = 0;
    
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      
      if ((k % a == 0) && (a > maxDev)) {
        maxDev = a;
      }
    }
    
    System.out.println(k / maxDev);
  }
}