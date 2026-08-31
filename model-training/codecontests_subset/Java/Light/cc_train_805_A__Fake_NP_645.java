import java.util.*;

public class CF_805A{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int left = in.nextInt();
    int right = in.nextInt();
    if( left == right ) System.out.println(left);
    else{
      if(left % 2 == 0){
        if( right % 2 == 0 ) System.out.println(2);
        else{
          if( right - left == 1 ) System.out.println(left);
          else System.out.println(2);
        }
      }
      else{
        if( right - left <= 2 ) System.out.println(left);
        else System.out.println(2);
      }
    }
  }
}