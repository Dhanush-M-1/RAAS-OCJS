import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    if(s.matches(".*keyence")||s.matches("k.*eyence")||s.matches("ke.*yence")||s.matches("key.*ence")||s.matches("keye.*nce")||s.matches("keyen.*ce")||s.matches("keyenc.*e")||s.matches("keyence.*"))
      System.out.println("YES");
    else System.out.println("NO");
  }
}