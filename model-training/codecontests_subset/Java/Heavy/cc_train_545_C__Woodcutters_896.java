import java.util.Scanner;

public class Solution {
    public static void main(final String[] arguments) {
        Scanner input = new Scanner(System.in);
        int[][] points = new int[input.nextInt()][2];
        int result = 2;

        if (points.length == 1) {
            result = 1;
        } else {
            for (int index = 0; index < points.length; index++) {
                points[index] = new int[]{input.nextInt(), input.nextInt()};
            }

            int leftOccupation = 0;

            for (int index = 1; index < points.length - 1; index++) {
                if (points[index - 1][0] + leftOccupation < points[index][0] - points[index][1]) {
                    // Occupy left.
                    result++;
                    leftOccupation = 0;
                } else if (points[index][0] < points[index + 1][0] - points[index][1]) {
                    // Occupy right.
                    result++;
                    leftOccupation = points[index][1];
                } else {
                    leftOccupation = 0;
                }
            }
        }

        System.out.println(result);
    }
}