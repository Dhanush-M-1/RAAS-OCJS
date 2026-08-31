import java.io.*;
import java.util.*;
import java.lang.*;

public class Woodcutters {
    //static int[] coins = {1, 5, 10, 25};

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int[] tree = new int[t];
        int[] height = new int[t];
        for (int i = 0; i < t; i++) {
            tree[i] = scan.nextInt();
            height[i] = scan.nextInt();
        }

        int fell = Math.min(t, 2);

        for (int i = 1; i < t - 1; i++) {
        	if (tree[i] - height[i] > tree[i - 1]) {
        		fell++;
        	} else if (tree[i] + height[i] < tree[i + 1]) {
        		fell++;
        		tree[i] = tree[i] + height[i];
        	}
        }

        System.out.println(fell);
    }
}
