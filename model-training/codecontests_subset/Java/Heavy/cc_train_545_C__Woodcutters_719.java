import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Codeforces
 * 545C: Woodcutters
 *
 * Time complexity:
 * Worst case: Θ()
 * Best case: Θ()
 *
 * Space complexity:
 * Worst case: Θ()
 * Best case: Θ()
 *
 * @author: Saksham Tiwari
 */

public class Woodcutters {
    /**
     * Function that takes in user input and prints the final answer.
     *
     * @param parameters Command line parameters.
     */
    public static void main(final String[] parameters) {
        Scanner input = new Scanner(System.in);

        int totalTrees = input.nextInt();
        int[][] trees = new int[totalTrees][2];

        for (int index = 0; index < totalTrees; index++) {
            trees[index][0] = input.nextInt();
            trees[index][1] = input.nextInt();
        }

        Arrays.sort(trees, Comparator.comparingDouble(arrayOne -> arrayOne[0]));

        System.out.println(totalTreesCut(trees));
    }

    static int totalTreesCut(int[][] trees) {
        int result = 1;
        int lastEmptySpot = trees[0][0];

        for (int index = 1; index < trees.length; index++) {
            if (index == trees.length - 1) {
                result++;
            } else if (lastEmptySpot < trees[index][0] - trees[index][1]) {
                lastEmptySpot = trees[index][0];
                result++;
            } else if (trees[index][0] + trees[index][1] < trees[index + 1][0]) {
                lastEmptySpot = trees[index][0] + trees[index][1];
                result++;
            } else {
                lastEmptySpot = trees[index][0];
            }
        }

        return result;
    }
}