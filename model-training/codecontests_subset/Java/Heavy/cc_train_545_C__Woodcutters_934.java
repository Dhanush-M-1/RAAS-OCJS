import java.util.*;

/**
 * Created by Alvin on 10/20/2015.
 */
public class Codeforces_round_303_div_2_Woodcutters {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();

        int x[] = new int[count];
        int h[] = new int[count];

        for(int i = 0; i < x.length; i++) {
            x[i] = input.nextInt();
            h[i] = input.nextInt();
        }

        int treeCount = 1; // Fall to the left for the first tree
        int currentPos = x[0];
        int currentX = 0;

        for(int i = 1; i < count - 1; i++) {

            currentX = x[i];

            if(currentX - h[i] > currentPos) { // Always cut left
                treeCount++;
                currentPos = currentX;
            } else if (currentX + h[i] < x[i+1]) { // Try to cut right
                treeCount++;
                currentPos = currentX + h[i];
            } else { // Don't cut
                currentPos = currentX;
            }
        }

        if(count > 1) { // The last can always fall to the right to be safe
            treeCount++;
        }

        System.out.println(treeCount);
    }
}