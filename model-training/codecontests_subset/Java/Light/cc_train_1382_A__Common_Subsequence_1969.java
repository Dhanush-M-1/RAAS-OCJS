import java.util.*;
public class commonSub {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t =scan.nextInt();
		for(int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			ArrayList<Integer> a = new ArrayList<>();
			ArrayList<Integer> b = new ArrayList<>();
			for(int j = 0; j < n; j++) {
				a.add(scan.nextInt());
			}
			for(int j = 0; j < m; j++) {
				b.add(scan.nextInt());
			}
			TreeMap<Integer, Integer> tmap = new TreeMap<>();
			for(int j = 0; j < m; j++) {
				if(a.contains(b.get(j))) {
					if(!tmap.containsKey(b.get(j))) {
						tmap.put(b.get(j), 1);
					}else {
						tmap.put(b.get(j), b.get(j) + 1);
					}
				}
			}
			ArrayList<shared> share = new ArrayList<>();
			for(Integer x: tmap.keySet()) {
				shared add = new shared(x, tmap.get(x));
				share.add(add);
			}
			Collections.sort(share);
			if(!share.isEmpty()) {
				System.out.println("YES");
				if(share.get(0).amount > 1) {
					System.out.println("1 " + share.get(0).value);
				}else {
					System.out.print(share.get(0).amount + " " + share.get(0).value);
				}
				System.out.println();
			}else {
				System.out.println("NO");
			}

		}
	}
}
class shared implements Comparable<shared>{
	public int value;
	public int amount;

	public shared(int v, int a) {
		value = v;
		amount = a;
	}

	public int compareTo(shared o) {
		if(amount != o.amount) return amount - o.amount;
		else {
			return value-o.value;
		}
	}

}
