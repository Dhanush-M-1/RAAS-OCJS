import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class b7 {
	static class range implements Comparable<range> {
		int s, l;

		public range(int s, int l) {
			this.s = s;
			this.l = l;
		}

		@Override
		public int compareTo(range o) {
			return s - o.s;
		}

		@Override
		public String toString() {
			return s + "->" + l;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ops = in.nextInt();
		int bytes = in.nextInt();
		TreeSet<range> used = new TreeSet<range>();
		TreeMap<Integer, range> find = new TreeMap<Integer, range>();
		int idx = 1;
		for (int i = 0; i < ops; i++) {
//			System.out.println("----" + used.size());
			char c = in.next().charAt(0);
			if (c == 'a') {
				int v = in.nextInt();
				boolean found = false;

				if ((used.size() == 0 && v <= bytes)
						|| (used.size() > 0 && used.first().s >= v)) {
					found = true;
					System.out.println(idx);
					range here = new range(0, v);
					used.add(here);
					find.put(idx++, here);
				} else {
					for (range b : used) {
						range here = new range(b.s + b.l, v);
						if (used.contains(here))
							continue;
						range higher = used.higher(here);
						int max = higher == null ? bytes : higher.s;
//						System.out.printf("checking %s with %s\n",
//								here.toString(),
//								higher == null ? "n" : higher.toString());
						if (here.s + here.l <= max) {
							found = true;
							System.out.println(idx);
							used.add(here);
//							System.out.println("!" + (b.s + b.l));
							find.put(idx++, here);
							break;
						}
					}
				}

				if (!found) {

					if (used.size() > 0) {
						range b = used.last();
						range here = new range(b.s + b.l, v);
						if (here.s + here.l <= bytes) {
							found = true;
							System.out.println(idx);
							used.add(here);
							find.put(idx++, here);
						}
					}
				}

				if (!found)
					System.out.println("NULL");
			} else if (c == 'e') {
				int v = in.nextInt();
				if (find.containsKey(v))
					used.remove(find.remove(v));
				else
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
			} else if (c == 'd') {
				for (range r : used) {
					range lower = used.lower(r);
					r.s = lower == null ? 0 : lower.s + lower.l;
				}
			}
		}
	}
}