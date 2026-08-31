
import java.util.Arrays;
import java.util.Scanner;

public class CF846BMathShow {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        int[] subtaskTimes = new int[k];
        int taskTime = 0;
        for (int i = 0; i < k; i++) {
            subtaskTimes[i] = in.nextInt();
            taskTime += subtaskTimes[i];
        }
        Arrays.sort(subtaskTimes);

        int largest = 0;
        for (int i = 0; i <= n; i++) {
            int timeForTask = taskTime * i;
            if (timeForTask > m)
                break;
            int score = i * (k + 1) + smallestSubtaskUp(n, k, m - timeForTask, i, subtaskTimes);
            if (score > largest)
                largest = score;
        }

        System.out.println(largest);

    }

    private static int smallestSubtaskUp(int n, int k, int m, int taskStart, int[] subtaskTimes) {
        int timeUsed = 0;
        int score = 0;

        outerloop:
        for (int subtask = 0; subtask < k; subtask++) {

            for (int task = taskStart; task < n; task++) {
                timeUsed += subtaskTimes[subtask];
                if (timeUsed > m) {
                    break outerloop;
                }
                score++;
            }
        }

        return score;
    }
}
