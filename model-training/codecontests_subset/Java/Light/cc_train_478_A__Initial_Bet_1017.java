import java.util.Scanner;

/**
 * Created by zephyr on 10/16/14.
 */
public class AllCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = 5;
        int index = 0;
        int total = 0;
        while (index < n){
            total += scanner.nextInt();
            index++;
        }
        int result = (total % 5 == 0 && total != 0 )? total / 5: -1;
        System.out.println(result);


    }
}