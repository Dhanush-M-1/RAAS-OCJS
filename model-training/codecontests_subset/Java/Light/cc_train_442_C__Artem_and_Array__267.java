import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class EArtemAndArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Entry[] entries = new Entry[n];
		LinkedList<Entry> array = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			Entry entry = new Entry(in.nextInt());
			if (i > 0) {
				Entry left = entries[i - 1];
				left.right = entry;
				entry.left = left;
			}
			entries[i] = entry;
			array.add(entry);
		}
		in.close();

		Arrays.sort(entries);

		long result = 0;
		for (int i = 0; i < n - 2; i++) {
			Entry entry = entries[i];
			Entry left = entry.left;
			Entry right = entry.right;
			if (left == null) {
				result += entry.value;
				entry.right.left = null;
			} else if (right == null) {
				result += entry.value;
				entry.left.right = null;
			} else {
				result += Math.min(left.value, right.value);
				entry.left.right = entry.right;
				entry.right.left = entry.left;
			}
		}
		System.out.println(result);
	}
}

class Entry implements Comparable<Entry> {
	Entry left, right;
	int value;

	public Entry(int value) {
		this.value = value;
		left = null;
		right = null;
	}

	@Override
	public int compareTo(Entry other) {
		return this.value - other.value;
	}
}