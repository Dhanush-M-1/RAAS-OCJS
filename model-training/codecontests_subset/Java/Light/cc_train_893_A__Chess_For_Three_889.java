import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChessStuff {

	

	public static void main(String[] args) {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int a;
		try {
			a = Integer.parseInt(br.readLine());
			int[] arr = new int[a];
			for (int i = 0; i < a; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			Solver sol = new Solver();

			sol.solve(arr);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Solver {

	public void solve(int[] arr) {	

			ArrayList<Integer> players = new ArrayList<>();
			players.add(0);
			players.add(0);
			int out = 0;
			for (int i = 0; i < arr.length; i++) {

			if (arr[i] == players.get(1) || (i == 0 && arr[i] == 3)) {
					out = -1;
					break;
				}

				if (i == 0) {
					players.set(0, arr[i]);
					if (players.get(0) == 1) {
						players.set(1, 2);
					} else {
						players.set(1, 1);
					}
				} else {
					players.set(0, arr[i]);
					if (players.indexOf(1) == -1) {
						players.set(1, 1);
					}
					else if (players.indexOf(2) == -1) {
						players.set(1, 2);
					}
					else {
						players.set(1, 3);
					}
				}
			}

			if (out == 0) {
				System.out.println("YES");
			}	else {
			System.out.println("NO");
		}

	}

}