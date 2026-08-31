import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Task task = new Task();
		task.getData();
		task.solve();
		task.printAnswer();
	}
}

class Task {
	int n, x, y;
	//StringBuilder answer = new StringBuilder();
	int answer = 0;

	public void getData() {
		Scanner console = new Scanner(System.in);

		n = console.nextInt();
		x = console.nextInt();
		y = console.nextInt();

		console.close();
	}

	public void solve() {
		//x + t >= y * n / 100;
		answer = Math.max((y * n + 100 - 1) / 100 - x, 0);
	}

	public void printAnswer() {
		System.out.print(answer);
	}
}

class Point {
	int f;
	int t;

	Point(int f, int t) {
		this.f = f;
		this.t = t;
	}
}