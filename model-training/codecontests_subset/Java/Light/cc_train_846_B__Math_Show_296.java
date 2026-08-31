import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        final int N = scanner.nextInt();
        final int K = scanner.nextInt();
        final long M = scanner.nextInt();
        final int arr[] = new int[K];
        long sumTime = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = scanner.nextInt();
            sumTime += arr[i];
        }
        if (sumTime * N <= M) {
            System.out.println(N * (K + 1));
            return;
        }
        int maxPoints = 0;
        Arrays.sort(arr);
        for (int solvedTasks = 0; solvedTasks < N; solvedTasks++) {
            if (solvedTasks * sumTime > M) break;
            int tasksPoints = solvedTasks * (K + 1);
            long remainingTime = M - solvedTasks * sumTime;
            final int unsolvedTasks = N - solvedTasks;
            for (int i = 0; i < K; i++) {
                if (unsolvedTasks * arr[i] <= remainingTime) {
                    tasksPoints += unsolvedTasks;
                    remainingTime -= (unsolvedTasks * arr[i]);
                } else {
                    tasksPoints += remainingTime / arr[i];
                    break;
                }
            }
            maxPoints = Math.max(maxPoints, tasksPoints);
        }
        System.out.println(maxPoints);
    }
}
