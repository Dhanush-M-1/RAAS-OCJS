
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums[] = new int[5];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int res = -1;
        if (sum != 0 && sum % 5 == 0)
            res = sum / 5;
        System.out.println(res);
    }
}
