
import java.util.*;
public class CodeIt {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.nextLine().split("\\+");
    Arrays.sort(s);
    String solved = String.join("+", s);
    System.out.println(solved);
    sc.close();
  }
}