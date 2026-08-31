import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matches {

	public static void main(String[] args) {
		List<Integer> firstTeam = new ArrayList<Integer>();
		List<Integer> secondTeam = new ArrayList<Integer>();
		Scanner scn = new Scanner(System.in);
		int matches = scn.nextInt();
		for (int i = 0; i < matches; i++) {
			int homeMatch = scn.nextInt();
			firstTeam.add(homeMatch);
			int outMatch = scn.nextInt();
			secondTeam.add(outMatch);
		}
		scn.close();
		int result = 0;
		for (int i = 0; i < firstTeam.size(); i++) {
			for (int k = 0; k < secondTeam.size(); k++) {
				if (firstTeam.get(i).equals(secondTeam.get(k))) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
