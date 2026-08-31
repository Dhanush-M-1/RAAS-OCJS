import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class AandBandCompilationErrors {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Integer, Integer> hMap = new HashMap<>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			addToHash(hMap, in.nextInt());
		}
		HashMap<Integer, Integer> hMap2 = new HashMap<>(hMap);
		for (int i = 0; i < n - 1; i++) {
			deleteFromHash(hMap2, in.nextInt());
		}
		Set<Integer> res1 = hMap2.keySet();

		System.out.println(res1.toArray()[0]);
		HashMap<Integer, Integer> hMap3 = new HashMap<>(hMap);
		for (int i = 0; i < n - 2; i++) {
			deleteFromHash(hMap3, in.nextInt());
		}
		deleteFromHash(hMap3, (int) res1.toArray()[0]);
		Set<Integer> res2 = hMap3.keySet();
		System.out.println(res2.toArray()[0]);

	}

	// addToTree an integer key returns new TreeMap
	public static HashMap<Integer, Integer> addToHash(
			HashMap<Integer, Integer> tMap, int newKey) {
		if (tMap.containsKey(newKey)) {
			tMap.put(newKey, tMap.get(newKey) + 1);
		} else {
			tMap.put(newKey, 1);
		}
		return tMap;
	}

	// delete from Tree an integer key returns new TreeMap
	public static HashMap<Integer, Integer> deleteFromHash(
			HashMap<Integer, Integer> tMap, int Key) {
		if (tMap.containsKey(Key))
			if (tMap.get(Key) >= 2) {
				tMap.put(Key, tMap.get(Key) - 1);
			} else {
				tMap.remove(Key);
			}
		return tMap;
	}

}
