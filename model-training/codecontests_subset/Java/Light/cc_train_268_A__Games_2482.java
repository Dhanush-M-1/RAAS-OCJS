import java.util.*;

public class Game {
	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		Scanner scan = new Scanner(System.in);
		byte n = scan.nextByte();
		Team team[] = new Team[n];

		for(byte i=0; i<n; i++) {
			team[i] = new Team(scan.nextInt(), scan.nextInt());
		}

		int count = 0;

		for(byte i=0; i<n; i++) {
			int h = team[i].h;

			for(byte j=0; j<n; j++) {
				if(j != i && team[j].a == h) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

	private class Team {
		public int h, a;

		public Team(int h, int a) {
			this.h = h;
			this.a = a;
		}
	}
}