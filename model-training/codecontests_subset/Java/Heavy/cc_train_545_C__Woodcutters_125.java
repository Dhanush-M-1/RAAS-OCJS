import java.util.Scanner;

public class Woodcutters {

    public static int n;
    public static int[] coordinates;
    public static int[] heights;
    public static int[][] memo = new int[100002][3];

    static {
        for (int i = 0; i < 100002; i++) {
            for (int j = 0; j < 3; j++) {
                memo[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        coordinates = new int[n+2];
        heights = new int[n+1];
        for (int i = 1; i <= n; i++) {
            coordinates[i] = s.nextInt();
            heights[i] = s.nextInt();
        }

        coordinates[0] = Integer.MIN_VALUE;
        coordinates[coordinates.length - 1] = Integer.MAX_VALUE;

        System.out.println(maxCut(1, 0));
    }

    public static int maxCut(int i, int fallDirection) {
        // base case
        if(i == n + 1) return 0;

        if (memo[i][fallDirection] != -1) return memo[i][fallDirection];

        int maxCutTrees = Integer.MIN_VALUE;
        // we have three choices

        if(fallDirection == 0) {
            // no fall
            maxCutTrees = Math.max(maxCutTrees, maxCut(i+1, 0));

            //fall left
            if(coordinates[i-1] < coordinates[i] - heights[i]) {
                maxCutTrees = Math.max(maxCutTrees, 1 + maxCut(i+1,1));
            }

            // fall right
            if (coordinates[i] + heights[i] < coordinates[i+1]) {
                maxCutTrees = Math.max(maxCutTrees, 1 + maxCut(i+1, 2));
            }
        } else if(fallDirection == 1) {
            // no fall
            maxCutTrees = Math.max(maxCutTrees, maxCut(i+1, 0));
            //fall left
            if(coordinates[i-1] < coordinates[i] - heights[i]) {
                maxCutTrees = Math.max(maxCutTrees, 1 + maxCut(i+1,1));
            }
            // fall right
            if (coordinates[i] + heights[i] < coordinates[i+1]) {
                maxCutTrees = Math.max(maxCutTrees, 1 + maxCut(i+1, 2));
            }
        } else {
            // no fall
            maxCutTrees = Math.max(maxCutTrees, maxCut(i+1, 0));
            //fall left
            if(coordinates[i-1] + heights[i-1] < coordinates[i] - heights[i]) {
                maxCutTrees = Math.max(maxCutTrees, 1 + maxCut(i+1,1));
            }
            // fall right
            if (coordinates[i] + heights[i] < coordinates[i+1]) {
                maxCutTrees = Math.max(maxCutTrees, 1 + maxCut(i+1, 2));
            }
        }

        return memo[i][fallDirection] = maxCutTrees;

    }
}
