import java.util.*;

public class Traffic {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    HashSet<String> names = new HashSet<String>();
    long total = 0;
    while (in.hasNext()) {
      String input = in.nextLine();
      input += " ";
      char c = input.charAt(0);
      if (c == '+') {
        names.add(input.substring(1)); continue;
      } else if (c == '-') {
        names.remove(input.substring(1)); continue;
      }
      String message = (input.split(":"))[1];
      total += names.size() * message.trim().length();
    }
    System.out.println(total);
  }
}