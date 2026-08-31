import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int imp = 3;
    for(int i = 0; i < n; i++){
      int a = sc.nextInt();
      if(a == imp){
        System.out.println("NO");
        return;
      }
      imp = 6 - (a + imp);
    }
    System.out.println("YES");
  }
}
