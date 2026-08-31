import java.util.*;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String firstString = scanner.nextLine();

    System.out.println(rearrange(firstString));

    scanner.close();
  }

  private static String rearrange(String firstString) {
    String[] addends = firstString.split("\\+");

    Arrays.sort(addends);

    String result = "";
    for (String currentAddend: addends) {
      result = result + currentAddend + "+";
    }

    return result.substring(0,result.length()-1);
  }
}
