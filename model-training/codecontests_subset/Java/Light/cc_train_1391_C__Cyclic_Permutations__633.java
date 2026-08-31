import java.util.Scanner;

public class CyclicPermutations {
    public static void main(final String[] parameters) {
        Scanner input = new Scanner(System.in);
        int arrayLength = input.nextInt();
        long factorial = 1;
        long power = 1;
        long modulus = 1000000007;

        for (int multiplier = 2; multiplier <= arrayLength; multiplier++) {
            factorial *= multiplier;
            power *= 2;

            factorial %= modulus;
            power %= modulus;
        }

        long totalCyclicPermutations = factorial - power;

        if (totalCyclicPermutations < 0) {
            totalCyclicPermutations += modulus;
        }

        System.out.println(totalCyclicPermutations);
    }
}
