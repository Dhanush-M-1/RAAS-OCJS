import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums[] = new int[in.nextInt()];
        for (int i = 0; i < nums.length; i++)
            nums[i] = in.nextInt();
        in.close();

        int count = 0;

        outerloop:
        for (int num : nums) {
            for (int i = 2; i <= Math.sqrt(num); i++)
                if (num % i == 0)
                    continue outerloop;
            ++count;
        }
        System.out.println(count);
    }
}

