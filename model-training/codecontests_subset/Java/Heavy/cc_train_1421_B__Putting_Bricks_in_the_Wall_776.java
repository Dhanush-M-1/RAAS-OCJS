import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			char[][] a = new char[n][n];
			for (int i = 0; i < n; i++)
				a[i] = sc.next().toCharArray();
			int ans = 0;
			int top1 = a[1][0];
			int top2 = a[0][1];

			int down1 = a[n - 1][n - 2];
			int down2 = a[n - 2][n - 1];
			String str = "";
			if (top1 == top2) {
				if (down1 == top1) {
					str += ((n - 1 + 1) + " " + (n - 2 + 1));
					str += "\n";
					ans++;
				}
				if (down2 == top1) {
					str += ((n - 2 + 1) + " " + (n - 1 + 1));
					str += "\n";
					ans++;
				}

			} else if (down1 == down2) {
				if (down1 == top1) {
					str += ((1 + 1) + " " + (0 + 1));
					str += "\n";
					ans++;
				}
				if (down2 == top2) {
					str += ((0 + 1) + " " + (1 + 1));
					str += "\n";
					ans++;
				}

			} else if (top1 != top2) {
				// make it 1
				/*
				 * int top1 = a[1][0]; int top2 = a[0][1];
				 * 
				 * int down1 = a[n - 1][n - 2]; int down2 = a[n - 2][n - 1];
				 */

				if (down1 == '0') {
					str += ((n - 1 + 1) + " " + (n - 2 + 1));
					str += "\n";
					ans++;
				}
				if (down2 == '0') {
					str += ((n - 2 + 1) + " " + (n - 1 + 1));
					str += "\n";
					ans++;
				}

				// make it 0
				if (top1 == '1') {
					str += ((1 + 1) + " " + (0 + 1));
					str += "\n";
					ans++;
				}
				if (top2 == '1') {
					str += ((0 + 1) + " " + (1 + 1));
					str += "\n";
					ans++;
				}

			}
			System.out.println(ans);
			System.out.print(str);

		}

	}

	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

}

class Scanner {
	BufferedReader br;
	StringTokenizer st;

	Scanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}
}

//creating a hash table
//Hashtable<Integer, String> h = new Hashtable<Integer, String>();
//
//Hashtable<Integer, String> h1 = new Hashtable<Integer, String>();
//
//h.put(3, "Geeks");
//h.put(2, "forGeeks");
//h.put(1, "isBest");
//System.out.println(h.get(1));
//if (h.containsKey(1)) {
//	System.out.println(1111111);
//}
//if (h.containsValue("isBest")) {
//	System.out.println(1111111);
//}
//
//// create a clone or shallow copy of hash table h
//h1 = (Hashtable<Integer, String>) h.clone();
//
//// checking clone h1
////System.out.println("values in clone: " + h1);
//
//// clear hash table h
//h.clear();

//Creating object of the 
// class linked list 
//LinkedList<String> ll 
//    = new LinkedList<String>(); 
//
//// Adding elements to the linked list 
//ll.add("A"); 
//ll.add("B"); 
//ll.addLast("C"); 
//ll.addFirst("D"); 
//ll.add(2, "E"); 
//
//System.out.println(ll); 
//
//ll.remove("B"); 
//ll.remove(3); 
//ll.removeFirst(); 
//ll.removeLast(); 
//
//System.out.println(ll); 

//Set<Integer> set = new HashSet<Integer>();
//try {
//   for(int i = 0; i < 5; i++) {
//      set.add(count[i]);
//   }
//   System.out.println(set);
//
//   TreeSet sortedSet = new TreeSet<Integer>(set);
//   System.out.println("The sorted list is:");
//   System.out.println(sortedSet);
//
//   System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
//   System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());
//}
//catch(Exception e) {}