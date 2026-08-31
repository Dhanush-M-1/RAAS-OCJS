
import java.util.*;

public class Main {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    int[] arr = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
    Arrays.sort(arr);

    System.out.println(arr[0] + arr[1] == arr[2] ? "Yes" : "No");
  }
}
