import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int t = Integer.parseInt(str);
        for (int i = 0; i < t; i++) {
            str = scan.nextLine();
            int n = Integer.parseInt(str);
            str = scan.nextLine();
            int[] arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (arr[n - 1] >= arr[0] + arr[1])
                System.out.println("1 2 " + n);
            else
                System.out.println("-1");
        }
    }
}