import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Lucky {

	static HashMap<par, Integer> mapA;
	static HashMap<par, Integer> mapB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int maxX = Integer.parseInt(line[0]);
		int maxY = Integer.parseInt(line[1]);
		int w = Integer.parseInt(line[2]);

		mapA = new HashMap<par, Integer>();
		par[] fracciones = new par[maxX + 1];
		for (int i = 1; i <= maxX; i++) {
			int rev = rev(i);
			int mcd = mcd(i, rev);
			par fraccion = new par(i / mcd, rev / mcd);
			fracciones[i] = fraccion;

			if (!mapA.containsKey(fraccion)) {
				mapA.put(fraccion, 0);
			}
			mapA.put(fraccion, mapA.get(fraccion) + 1);
		}

		mapB = new HashMap<par, Integer>();
		mapB.put(new par(1, 1), 1);

		int x = maxX;
		int y = 1;
		int tickets = mapA.get(new par(1, 1));

		int min = Integer.MAX_VALUE;
		int minX = 0;
		int minY = 0;

		while (y <= maxY && x >= 1) {
			// si es que el punto sirve.
			if (tickets >= w) {
				// chequear si es minimo.
				if (x * y < min) {
					min = x * y;
					minX = x;
					minY = y;
				}
				// moverse a la izquierda.
				mapA.put(fracciones[x], mapA.get(fracciones[x]) - 1);
				if (mapB.containsKey(fracciones[x])) {
					tickets -= mapB.get(fracciones[x]);
				}
				x--;

			} else {
				// moverse hacia arriba.
				y++;

				int rev = rev(y);
				int mcd = mcd(y, rev);
				par fraccion = new par(rev / mcd, y / mcd);

				if (!mapB.containsKey(fraccion)) {
					mapB.put(fraccion, 0);
				}
				mapB.put(fraccion, mapB.get(fraccion) + 1);
				if (mapA.containsKey(fraccion)) {
					tickets += mapA.get(fraccion);
				}
			}
		}

		if (minX == 0) {
			System.out.println(-1);
		} else {
			System.out.println(minX + " " + minY);
		}

	}

	private static int rev(int i) {
		int rev = 0;
		int l = Integer.toString(i).length();

		for (int j = 0; j < l; j++) {
			rev *= 10;
			rev += i % 10;
			i /= 10;
		}

		return rev;
	}

	public static int mcd(int a, int b) {
		if (b == 0)
			return a;
		return mcd(b, a % b);
	}

	static class par implements Comparable<par> {
		int x;
		int y;

		public par(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}

		@Override
		public int compareTo(par arg) {
			if (this.x != arg.x)
				return this.x - arg.x;
			return this.y - arg.y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			par other = (par) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
