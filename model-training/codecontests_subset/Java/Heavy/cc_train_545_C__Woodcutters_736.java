import java.io.*;
import java.util.*;

public class C {

	static class Tree implements Comparable<Tree> {
		int pos;
		int height;

		Tree(int pos, int height) {
			this.pos = pos;
			this.height = height;
		}

		public int compareTo(Tree o) {
			return Integer.valueOf(this.pos).compareTo(o.pos);
		}
	}

	public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(input.readLine());

		int n = Integer.parseInt(line.nextToken());
		Tree[] forest = new Tree[n];

		for (int i = 0; i < n; i++) {
			line = new StringTokenizer(input.readLine());
			forest[i] = new Tree(Integer.parseInt(line.nextToken()), Integer.parseInt(line.nextToken()));
		}

		Arrays.sort(forest);
		int lastPos = Integer.MIN_VALUE;
		int count = 0;

		for (int i = 0; i < n - 1; i++) {
			int x = forest[i].pos;
			int h = forest[i].height;
			if (x - h > lastPos) {
				count++;
				lastPos = x;
			} else if (x + h < forest[i + 1].pos) {
				count++;
				lastPos = x + h;
			} else {
				lastPos = x;
			}
		}
		count++;

		System.out.println(count);
	}
}
