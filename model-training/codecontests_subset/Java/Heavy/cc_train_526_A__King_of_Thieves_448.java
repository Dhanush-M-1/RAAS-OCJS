import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String maze = in.next();
        boolean good = false;
        for (int i = 0; i < maze.length() && !good; i++) {
            if (maze.charAt(i) != '*')
                continue;

            for (int j = 1; j < maze.length() && !good; j++) {
                int k;
                for (k = 1; k < 5 && (i + (k * j)) < n; k++) {
                    if (maze.charAt(i + (j * k)) != '*')
                        break;

                }
                if (k == 5)
                    good = true;
            }
        }
        System.out.println((good) ? "yes" : "no");

    }

}