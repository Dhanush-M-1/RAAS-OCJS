import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineParts = scanner.nextLine().split(" ");
        int n = Integer.parseInt(lineParts[0]);
        long[] arr = new long[n];
        lineParts = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(lineParts[i]);
        }

        int[] lengthCounts = new int[11];
        long[] digitSums = new long[10];
        for (int i = 0; i < n; i++) {
            long num = arr[i];
            int length = String.valueOf(num).length();
            lengthCounts[length]++;

            char[] digits = String.valueOf(num).toCharArray();
            for (int j = 0; j < digits.length; j++) {
                digitSums[j] += Integer.parseInt(String.valueOf(digits[digits.length - j - 1]));
            }
        }

        long modulo = 998_244_353;
        BigInteger sum = BigInteger.ZERO;

        for (int digitIndex = 0; digitIndex < digitSums.length; digitIndex++) {
            long digitSum = digitSums[digitIndex];

            int power = digitIndex;
            int j = 0;
            for (; j < digitIndex; j++) {
                int count = lengthCounts[j];
                BigInteger coefficient = BigInteger.valueOf(10).pow(power);
                sum = sum.add(coefficient.multiply(BigInteger.valueOf(digitSum).multiply(BigInteger.valueOf(count))));
                power++;
            }

            BigInteger coefficient = BigInteger.valueOf(10).pow(power);
            for (; j < lengthCounts.length; j++) {
                int count = lengthCounts[j];
                sum = sum.add(coefficient.multiply(BigInteger.valueOf(digitSum).multiply(BigInteger.valueOf(count))));
            }

            power = digitIndex;
            j = 0;
            for (; j <= digitIndex; j++) {
                int count = lengthCounts[j];
                coefficient = BigInteger.valueOf(10).pow(power);
                sum = sum.add(coefficient.multiply(BigInteger.valueOf(digitSum).multiply(BigInteger.valueOf(count))));
                power++;
            }

            coefficient = BigInteger.valueOf(10).pow(power);
            for (; j < lengthCounts.length; j++) {
                int count = lengthCounts[j];
                sum = sum.add(coefficient.multiply(BigInteger.valueOf(digitSum).multiply(BigInteger.valueOf(count))));
            }
        }

        System.out.println(sum.mod(BigInteger.valueOf(modulo)).toString());
    }
}
