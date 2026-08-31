import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		Task task = new Task();
		task.getData();
		task.solve();
		task.printAnswer();
	}
}

class Task {
	int r1, r2, c1, c2, d1, d2;

	StringBuilder answer = new StringBuilder();

	public void getData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] data = br.readLine().split(" ");
		r1 = Integer.parseInt(data[0]);
		r2 = Integer.parseInt(data[1]);
		
		data = br.readLine().split(" ");
		c1 = Integer.parseInt(data[0]);
		c2 = Integer.parseInt(data[1]);
		
		data = br.readLine().split(" ");
		d1 = Integer.parseInt(data[0]);
		d2 = Integer.parseInt(data[1]);
	}

	public void solve() {
		for (int x11 = 1; x11 <= 9; ++x11) {
			int x12 = r1 - x11;
			int x21 = c1 - x11;
			int x22 = r2 - x21;

			if (x12 > 9 || x12 < 1 || x21 > 9 || x21 < 1 || x22 > 9 || x22 < 1) {
				continue;
			}
			if (x12 + x22 != c2 || x11 + x22 != d1 || x12 + x21 != d2) {
				continue;
			}
			if (x11 == x12 || x11 == x21 || x11 == x22 || x12 == x21 || x12 == x22 || x21 == x22) {
				continue;
			}
			answer.append(x11 + " " + x12 + "\n" + x21 + " " + x22);
			return;
		}
		answer.append(-1);
	}

	public void printAnswer() {
		System.out.print(answer);
	}
}

class Coder {
	String nick;
	int plus;
	int minus;
	int[] taskScores;

	Coder(String nick, int plus, int minus, int[] taskScores) {
		this.nick = nick;
		this.plus = plus;
		this.minus = minus;
		//this.taskScores = new int[taskScores.length];
		this.taskScores = Arrays.copyOf(taskScores, taskScores.length);
		
	}
}