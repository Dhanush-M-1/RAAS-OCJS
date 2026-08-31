import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int teamNum = sc.nextInt();
//		System.out.println(teamNum);
		int count = 0;
		Map<Integer, Integer> mapValue = new HashMap<>();
		Map<Integer, Integer> mapKey = new HashMap<>();
		for (int i = 0; i < teamNum; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			mapValue.merge(n, 1, Integer::sum);
			mapKey.merge(m, 1, Integer::sum);
			
//			System.out.println(n + " " + m);

		}
		int sum=0;
//		mapKey.forEach((k,v)->System.out.println(k+ " -- "+v));
		for (Map.Entry<Integer, Integer> entryValue : mapValue.entrySet()) {

			for (Map.Entry<Integer, Integer> entryKey : mapKey.entrySet()) {
				if (entryValue.getKey() == (entryKey.getKey())) {
					count= entryValue.getValue() * entryKey.getValue();
					sum= count+sum;
				}
			}

//			System.out.println("******************");

		}

		System.out.println(sum);

	}
}