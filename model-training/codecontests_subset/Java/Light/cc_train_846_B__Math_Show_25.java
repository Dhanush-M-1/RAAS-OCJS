//package test;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(t);
		int taskCost = 0;
		for (int i = 0; i < k; i++) {
			taskCost += t[i];
		}
		if (n*taskCost <= m) {
			System.out.println(n*(k+1));
			return;
		}
		int max = 0;
		for (int completedTasks = 0; completedTasks < n; completedTasks++) {
			int remainingTime = m - taskCost*completedTasks;
			if (remainingTime < 0) continue;
			int problemsCount = 0;
			for (int curProblem = 0; curProblem < k; curProblem++) {
				if (remainingTime < t[curProblem]) break;
				int canSolve = 0;
				if (t[curProblem]*(n-completedTasks) <= remainingTime) {
					canSolve = n - completedTasks;
				} else {
					canSolve =  remainingTime / t[curProblem];
				}
				problemsCount += canSolve;
				remainingTime -= canSolve * t[curProblem];
			}
			max = Math.max(max, problemsCount + completedTasks * (k + 1));
		}
		System.out.println(max);
	}
}