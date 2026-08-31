import java.util.*;
public class problem1{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int q = s.nextInt();
    for(int i = 1; i<=q; i++){
      int a = s.nextInt();
      int b = s.nextInt();
      int c = s.nextInt();
      int stones = 0;
      while(c>1&&b>0){
        stones += 3;
        c -= 2;
        b -= 1;
      }
      while(b>1&&a>0){
        stones += 3;
        b-=2;
        a-=1;
      }
      System.out.println(stones);
    }
  }
}
