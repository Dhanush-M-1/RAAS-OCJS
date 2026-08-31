import java.util.*;

public class BearandRaspberry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner q = new Scanner(System.in);
		int n = q.nextInt();
		int m = q.nextInt();
		ArrayList<Integer> array = new ArrayList<>();
		ArrayList<Integer> maxArray = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			array.add(q.nextInt());
		}
		int b = array.get(0);
		int s = array.get(1);
		maxArray.add(b - s - m);
		for (int i = 1; i < array.size()-1; i++) {
			if (i != array.size() - 1) {
				
				maxArray.add(array.get(i) - array.get(i + 1) - m);

			}

		}
		Collections.sort(maxArray);
		if (maxArray.get(maxArray.size()-1)<0) {
			System.out.println(0);
		}
		else {
			System.out.println(maxArray.get(maxArray.size()-1));
		}

	}

}
