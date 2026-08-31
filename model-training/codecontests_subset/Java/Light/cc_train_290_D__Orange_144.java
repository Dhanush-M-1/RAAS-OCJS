import java.util.*;
public class cf290d {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String x = in.next().trim().toLowerCase();
    int v = in.nextInt();
    for(char c : x.toCharArray())
      if(c < v + 97)
        System.out.print(Character.toUpperCase(c));
      else 
        System.out.print(c);
  }
}
