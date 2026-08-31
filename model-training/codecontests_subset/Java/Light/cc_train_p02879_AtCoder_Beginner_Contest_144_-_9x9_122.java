import java.util.*;
public class Main{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    int n = input.nextInt();
    int m = input.nextInt();
    
    if(n>9||m>9)
      System.out.println(-1);
    else
      System.out.println(n*m);
  }
}
