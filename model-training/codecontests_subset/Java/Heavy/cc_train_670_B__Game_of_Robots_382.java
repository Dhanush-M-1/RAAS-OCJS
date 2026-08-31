import java.util.Scanner;

public class Game_Of_Robots_670_B
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] robots = new int[n];
        for (int i = 0; i < n; i++) {
            robots[i] = scan.nextInt();
        }
        int counter = 0;
        int answer = -1;
        int multiplier = 1;
        for (int i = 0; i < n; i++) {
            counter += multiplier;
            if (counter >= k) {
                counter -= multiplier;
                answer = k - counter;
            }
            multiplier++;
//            for (int j = 0; j <= i; j++) {
//                counter++;
//                if (counter == k) {
//                    answer = robots[j];
//                }
//            }
        }
        System.out.println(robots[answer-1]);
    }

}
