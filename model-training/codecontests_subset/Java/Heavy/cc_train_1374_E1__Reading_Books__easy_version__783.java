
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	static class Book implements Comparable<Book> {
		int alice;
		int bob;
		int time;

		public Book(int alice, int bob, int time) {
			this.alice = alice;
			this.bob = bob;
			this.time = time;
		}

		@Override
		public int compareTo(Book o) {

			return Integer.valueOf(this.time).compareTo(o.time);
		}

	}

	public static int getMin(PriorityQueue<Book> common, PriorityQueue<Book> alice, PriorityQueue<Book> bob) {
		if (common.size() == 0 && (alice.size() == 0 || bob.size() == 0)) {
			return -1;
		}
		int sumTime = common.size() > 0 ? common.peek().time : Integer.MAX_VALUE;

		int ind = Integer.MAX_VALUE;
		if (alice.size() > 0 && bob.size() > 0) {
			ind = alice.peek().time + bob.peek().time;
		}
		if (sumTime <= ind) {
			common.remove();
			return sumTime;
		} else if (ind < sumTime) {
			bob.remove();
			alice.remove();
			return ind;
		}

		return -1;
	}

	public static int readBooks(List<Book> list, int books) {

		PriorityQueue<Book> both = new PriorityQueue<Book>();
		PriorityQueue<Book> al = new PriorityQueue<Book>();
		PriorityQueue<Book> bob = new PriorityQueue<Book>();

		for (Book t : list) {
			if (t.alice + t.bob == 2) {
				both.add(t);
			} else if (t.alice == 1) {
				al.add(t);
			} else if (t.bob == 1) {
				bob.add(t);
			}
		}

		int result = 0;
		int i = 0;
		for (i = 0; i < books; i++) {
			int temp = getMin(both, al, bob);
			if (temp == -1) {
				return -1;
			}
			result += temp;
		}
		if (i == books) {
			return result;
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line[] = null;
		ArrayList<Book> list = new ArrayList<Book>();
		list.clear();
		line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		for (int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			list.add(new Book(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[0])));
		}
		System.out.println(readBooks(list, k));

	}

}
