import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;

public class MemoryManager {
	static class Y implements Comparable<Y> {
		int index, start;

		public Y(int i, int s) {
			index = i;
			start = s;
		}

		public int compareTo(Y arg0) {
			return start - arg0.start;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		String[] sp = s.split(" ");
		int t = new Integer(sp[0]);
		int m = new Integer(sp[1]);
		int index = 1;
		boolean[] arr = new boolean[m];
		int[] ss = new int[101];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		while (t-- > 0) {

			s = r.readLine();
			sp = s.split(" ");
			if (sp[0].equals("alloc")) {
				int size = new Integer(sp[1]);
				boolean can = false;
				for (int i = 0; i <= m - size; i++) {
					boolean ex = true;
					for (int j = 0; j < size; j++) {
						if (arr[i + j]) {
							ex = false;
							break;
						}
					}
					if (ex) {
						for (int j = 0; j < size; j++) {
							arr[i + j] = true;
						}
						can = true;
						ss[index] = size;
						System.out.println(index);
						hm.put(index++, i);
						break;
					}
				}
				if (!can)
					System.out.println("NULL");
			}
			if (sp[0].equals("erase")) {
				int block = new Integer(sp[1]);
				if (!hm.containsKey(block)) {
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
				} else {
					int start = hm.remove(block);

					for (int i = 0; i < ss[block]; i++) {
						arr[start + i] = false;
					}

					ss[block] = 0;
				}
			}
			if (sp[0].equals("defragment")) {
				int count = 0;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i])
						count++;
				}
				boolean[] ne = new boolean[m];
				for (int i = 0; i < count; i++) {
					ne[i] = true;
				}
				arr = ne;
				int curr = 0;
				Vector<Y> vec = new Vector<Y>();
				for (Entry<Integer, Integer> e : hm.entrySet()) {
					vec.add(new Y(e.getKey(), e.getValue()));
				}
				Collections.sort(vec);
				for (Y y : vec) {
					hm.remove(y.index);
					hm.put(y.index, curr);
					curr += ss[y.index];
				}

			}
		}
	}
}
