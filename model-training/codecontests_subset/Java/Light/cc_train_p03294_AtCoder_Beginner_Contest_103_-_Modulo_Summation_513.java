import java.util.Scanner;
import java.util.Arrays;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long sum = -n;
    while(n-- > 0){
      sum+=sc.nextInt();
    }
    System.out.println(sum);
  }
}
