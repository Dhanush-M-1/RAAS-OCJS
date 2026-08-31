import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int ma, md, ms;

	public static void main(String[] args) {
		System.out.println(solve());
	}

	static int solve() {
		int N = Integer.parseInt(sc.next());
		int mh = Integer.parseInt(sc.next());
		ma = Integer.parseInt(sc.next());
		md = Integer.parseInt(sc.next());
		ms = Integer.parseInt(sc.next());
		long cmh = mh;
		ArrayList<Enemy> es = new ArrayList<Enemy>();
		long sum = 0;
		for (int i = 0; i < N; ++i) {
			int h = Integer.parseInt(sc.next());
			int a = Integer.parseInt(sc.next());
			int d = Integer.parseInt(sc.next());
			int s = Integer.parseInt(sc.next());
			int receive = a - md;
			if (receive <= 0) continue;
			int attack = ma - d;
			if (attack <= 0) return -1;
			sum += receive;
			Enemy e = new Enemy(h, a, d, s);
			es.add(e);
			e.turn = (h + attack - 1) / attack;
			e.dm = receive;
		}
		Collections.sort(es);
		for (int i = 0; i < es.size(); ++i) {
			sum -= es.get(i).a - md;
			cmh -= sum * es.get(i).turn;
			cmh -= es.get(i).dm * (es.get(i).s > ms ? es.get(i).turn : es.get(i).turn - 1);
			if (cmh <= 0) return -1;
		}
		return (int) (mh - cmh);
	}

	static class Enemy implements Comparable<Enemy> {
		int h, a, d, s;
		long turn;
		int dm;

		public Enemy(int h, int a, int d, int s) {
			this.h = h;
			this.a = a;
			this.d = d;
			this.s = s;
		}

		public int compareTo(Enemy o) {
			long totalTurn = this.turn + o.turn;
			long d1 = (this.a - md) * (this.s > ms ? this.turn : this.turn - 1); // this -> o
			d1 += (o.a - md) * (o.s > ms ? totalTurn : totalTurn - 1);
			long d2 = (o.a - md) * (o.s > ms ? o.turn : o.turn - 1); // o -> this
			d2 += (this.a - md) * (this.s > ms ? totalTurn : totalTurn - 1);
			if (d1 != d2) return d1 < d2 ? -1 : 1;
			return 0;
		}
	}
}