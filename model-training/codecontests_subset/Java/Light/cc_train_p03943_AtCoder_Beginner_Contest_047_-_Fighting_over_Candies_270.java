import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] candies = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
    Arrays.sort(candies);
    if (candies[2] == candies[0] + candies[1]) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
