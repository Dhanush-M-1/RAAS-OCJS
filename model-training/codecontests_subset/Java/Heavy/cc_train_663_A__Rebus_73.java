import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static long summer(long[] nums){
        long output = 0;
        for (long x : nums)
            output += x;
        return output;
    }
    public static void main(String[] args) {
        String s = scanner.nextLine();
        int n = Integer.parseInt(s.substring(s.indexOf("=") + 2)), j = 0, k = 1;
        long sum = 0;
        long[] nums = new long[110];
        nums[0] = 1;
        for (int i = 0, range = s.length(); i < range; i++)
            if (s.charAt(i) == '+')
                nums[k++] = 1;
            else if (s.charAt(i) == '-')
                nums[k++] = -n;
        for (long x : nums)
            sum += x;
        while (sum < n) {
            if (j >= k)
                break;
            if (nums[j] > 0)
                if (sum > 1) {
                    nums[j] = n - sum + 1;
                    sum = n;
                    long sxm = summer(nums);
                    if (sxm != sum)
                        System.err.print("Zereshk1");
                } else {
                    nums[j] = n;
                    sum += n - 1;
                    long sxm = summer(nums);
                    if (sxm != sum)
                        System.err.print("Zereshk2");
                }
            else {
                if (sum > 1) {
                    nums[j] += n - sum;
                    sum = n;
                    long sxm = summer(nums);
                    if (sxm != sum)
                        System.err.print("Zereshk3");
                } else {
                    sum += (n - 1);
                    nums[j] = -1;
                    long sxm = summer(nums);
                    if (sxm != sum)
                        System.err.print("Zereshk4");
                }

            }
            j++;
        }
        if (sum != n)
            System.out.print("Impossible");
        else {
            System.out.print("Possible\n" + nums[0] + " ");
            for (int i = 1; i < k; i++)
                if (nums[i] > 0)
                    System.out.print("+ " + nums[i] + " ");
                else
                    System.out.print("- " + -nums[i] + " ");
            System.out.print("= " + n);
        }

    }
}