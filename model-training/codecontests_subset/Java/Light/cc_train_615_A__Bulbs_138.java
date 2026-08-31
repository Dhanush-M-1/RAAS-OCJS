import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class CodeForces138 {
  public static void main(String argv[]) {
    Scanner scanner = new Scanner(System.in);
    
    Set<Integer> hash = new HashSet<>();
    
    int buttons = scanner.nextInt();
    int bulbs = scanner.nextInt();
    
    for(int i = 0; i < buttons; i++) {
      int size = scanner.nextInt();
      for(int j = 0; j < size; j++) {
        hash.add(scanner.nextInt());
      }
    }
    
    if(hash.size() == bulbs) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    
    scanner.close();
  }
}
