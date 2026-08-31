import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class Source {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		List<Team> teams = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			teams.add(new Team(scan.nextInt(), scan.nextInt()));
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (teams.get(i).home == teams.get(j).away) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

}

class Team {
	int home;
	int away;

	public Team(int home, int away) {
		this.home = home;
		this.away = away;
	}
}

