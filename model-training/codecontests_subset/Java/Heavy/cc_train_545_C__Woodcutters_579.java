import java.util.*;

public class WoodCutter {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] coordinates = new int[n];
        int [] heights = new int[n];
        
        for (int i = 0; i < n; i++) {
            coordinates[i] = in.nextInt();
            heights[i] = in.nextInt();
        }

        if (coordinates.length == 1) {
            System.out.println(1);
            return;
        }
        
        int count = 2;
        int currentCoordinate = coordinates[0];

        for (int i = 1; i < n - 1; i++) {
            if (coordinates[i] - currentCoordinate > heights[i]) {
                currentCoordinate = coordinates[i];
                count++;
            }
            else if (coordinates[i+1] - coordinates[i] > heights[i]) {
                currentCoordinate = coordinates[i] + heights[i];
                count++;
            }
            else {
                currentCoordinate = coordinates[i];
            }
        }

        System.out.println(count);
        in.close();
    }
}