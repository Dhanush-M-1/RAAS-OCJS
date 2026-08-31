import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class LuckyTickets {
	private int[] rev, accSymmetrical;
	private int[][] nRevFraction, orderedNRevFraction;
	private int x, y, maxX, maxY, w;
	private long xy, tempW;
	private boolean swappedXY;
	//private ArrayList<Integer>[] nonSymmetrical;

	private static final int MAX = 100_000;

	private LuckyTickets() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		maxX = Integer.parseInt(split[0]);
		maxY = Integer.parseInt(split[1]);
		w = Integer.parseInt(split[2]);

		if (maxX < maxY) {
			swappedXY = true;
			int aux = maxX;
			maxX = maxY;
			maxY = aux;
		}

		x = maxX;
		y = maxY;
		xy = Long.MAX_VALUE;

		calcRev();
		calcSymmetricals();
		calcRevFractions();
		orderedNRevFraction = new int[MAX + 1][4];
		// System.out.println("\nnRevFraction:");
		for (int i = 0; i < nRevFraction.length; i++) {
			orderedNRevFraction[i] = nRevFraction[i];
			// System.out.println(Arrays.toString(orderedNRevFraction[i]));
		}
		// orderedNRevFraction = Arrays.copyOf(nRevFraction, nRevFraction.length);
		Arrays.sort(orderedNRevFraction, compFrac0);

		// calcNonSymmetricals();
		calcCount();
/*
		System.out.println("\nnRevFraction:");
		for (int i = 0; i < 135; i++) {
			System.out.println(Arrays.toString(nRevFraction[i]));
		}
		System.out.println("\norderedNRevFraction:");
		for (int i = 0; i <= MAX; i++) {
			System.out.println(Arrays.toString(orderedNRevFraction[i]));
		}
*/
		// buscar min Y
		y = minY();
		//System.out.println("minY(" + maxX + ")=" + y);
		if (y < 1) {
			System.out.println("-1");
			return;
		}
		xy = mult(x, y);
		//System.out.println("tempW=" + tempW + " w=" + w);

		//System.out.println("count(12, 2)=" + count(12, 2));

		for (int i = x, j = y, aux; i >= j;) {
			aux = count(i, j);
			//System.out.println("i=" + i + " j=" + j + " aux=" + aux + " tempW=" + tempW);
			if (tempW - aux < w) {
				j++;
				tempW += count(j, i);
			} else {
				tempW -= aux;
				i--;
				long m = mult(i, j);
				if (m < xy) {
					x = i;
					y = j;
					xy = m;
				}
			}
		}

		printResult();
	}

	/*
	 * private void calcNonSymmetricals() { nonSymmetrical = new ArrayList[MAX + 1]; nonSymmetrical[1] = new ArrayList<Integer>(); for (int i = 1; i <
	 * accSymmetrical.length; i++) { if (isSymmetric(i)) { nonSymmetrical[1].add(i); } } for (int i = 2; i < accSymmetrical.length; i++) { if (isSymmetric(i)) {
	 * nonSymmetrical[i] = nonSymmetrical[1]; } else { nonSymmetrical[i] = new ArrayList<Integer>(); } }
	 * 
	 * for (int i = 1; i < accSymmetrical.length; i++) { if (isSymmetric(i)) continue;
	 * 
	 * 
	 * } }
	 */
	private void printResult() {
		if (swappedXY) {
			int aux = x;
			x = y;
			y = aux;
		}
		if (xy < Long.MAX_VALUE && y > 0 && x > 0)
			System.out.println(x + " " + y);
		else
			System.out.println("-1");
	}

	private void calcSymmetricals() {
		accSymmetrical = new int[MAX + 1];
		for (int i = 1; i < accSymmetrical.length; i++) {
			if (isSymmetric(i))
				accSymmetrical[i] = accSymmetrical[i - 1] + 1;
			else
				accSymmetrical[i] = accSymmetrical[i - 1];
		}
	}

	private long mult(long x, long y) {
		return x * y;
	}

	// Retorna el mínimo Y tal que hay W Lucky Numbers con X máximo
	private int minY() {
		long acc = 0;
		for (int i = 1; i <= maxY; i++) {
			acc += count(i, maxX);
			// System.out.println("acc="+acc);
			//System.out.println("acc=" + acc + " count(" + i + ", " + maxX + ")=" + count(i, maxX));
			if (acc >= w) {
				tempW = acc;
				return i;
			}
		}
		return -1;
	}

	// Numero de Lucky Tickets en la serie x hasta el ticket y
	private int count(int x, int y) {
		//System.out.println("isSymmetric(" + x + ")=" + isSymmetric(x));
		if (isSymmetric(x)) {
			return accSymmetrical[y];
		}
		//System.out.println("isLucky(" + x + ", " + y + ")=" + isLucky(x, y));
		if (isLucky(x, y)) {
			return nRevFraction[y][3];
		}
		int low = 1, high = MAX, mid = 1, comp;
		int[] target = new int[4];
		target[0] = y;
		target[1] = nRevFraction[x][2];
		target[2] = nRevFraction[x][1];

		while (high > low) {
			mid = low + (high - low) / 2;
			comp = compFrac0.compare(orderedNRevFraction[mid], target);
			if (comp > 0) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		//System.out.println("oNRF[" + (low - 1) + "]=" + Arrays.toString(orderedNRevFraction[low - 1]));
		if (isLucky(x, orderedNRevFraction[low - 1][0]))
			return orderedNRevFraction[low - 1][3];
		return 0;
	}

	private Comparator<int[]> compFrac0 = new Comparator<int[]>() {
		long a1b2, b1a2;

		@Override
		public int compare(int[] a, int[] b) {
			a1b2 = 1L * a[1] * b[2];
			b1a2 = 1L * b[1] * a[2];
			if (a1b2 > b1a2)
				return 1;
			else if (a1b2 < b1a2)
				return -1;
			else if (a[0] > b[0])
				return 1;
			else if (a[0] < b[0])
				return -1;
			else
				return 0;
		}
	};

	private void calcCount() {
		for (int j = 1; j < orderedNRevFraction.length; j++) {
			if (orderedNRevFraction[j - 1][1] == orderedNRevFraction[j][1] && orderedNRevFraction[j - 1][2] == orderedNRevFraction[j][2]) {
				orderedNRevFraction[j][3] = orderedNRevFraction[j - 1][3] + 1;
			} else {
				orderedNRevFraction[j][3] = 1;
			}
		}
	}

	private void calcRevFractions() {
		// para cada i, guardo i, i/rev(i) irreducible y el número de lucky tickets acumulado con i/rev(i) igual
		nRevFraction = new int[MAX + 1][4];
		nRevFraction[0][2] = 1;
		for (int i = 1, gcd; i < nRevFraction.length; i++) {
			gcd = gcd(i, rev[i]);
			nRevFraction[i][0] = i;
			nRevFraction[i][1] = i / gcd;
			nRevFraction[i][2] = rev[i] / gcd;
			nRevFraction[i][3] = 1;
		}
	}

	private int gcd(int a, int b) {
		int d = 0;

		while ((a & 1) == 0 && (b & 1) == 0) {
			a >>= 1;
			b >>= 1;
			d++;
		}

		if (a == 1 || b == 1) {
			return 1 << d;
		}

		while (a != b) {
			if ((a & 1) == 0) {
				a >>= 1;
			} else if ((b & 1) == 0) {
				b >>= 1;
			} else if (a > b) {
				a = (a - b) >> 1;
			} else {
				b = (b - a) >> 1;
			}
		}

		return a << d;
	}

	private boolean isLucky(int x, int y) {
		if ((isSymmetric(x) && isSymmetric(y)) || (x == rev[y] && y == rev[x]) || 1L * x * y == 1L * rev[x] * rev[y]) {
			return true;
		}

		return x * y == rev[x] * rev[y];
	}

	private boolean isSymmetric(int n) {
		return n == rev[n];
	}

	private void calcRev() {
		rev = new int[MAX + 1];
		rev[MAX] = 1;

		// n = a => rev(n) = a
		for (int a = 1; a < 10; a++) {
			rev[a] = a;
		}

		// n = 10*a + b => rev(n) = 10*b + a
		for (int i = 10, a = 1; a < 10; i += 10, a++) {
			for (int b = 0; b < 10; b++) {
				rev[i + b] = 10 * b + a;
			}
		}

		// n = 100*a + 10*b + c => rev(n) = 100*c + 10*b + a
		for (int i = 100, a = 1; a < 10; i += 100, a++) {
			for (int j = 0, b = 0; b < 10; j += 10, b++) {
				for (int c = 0; c < 10; c++) {
					rev[i + j + c] = 100 * c + 10 * b + a;
				}
			}
		}

		// n = 1000*a + 100*b + 10*c + d => rev(n) = 1000*d + 100*c + 10*b + a
		for (int i = 1000, a = 1; a < 10; i += 1000, a++) {
			for (int j = 0, b = 0; b < 10; j += 100, b++) {
				for (int k = 0, c = 0; c < 10; k += 10, c++) {
					for (int d = 0; d < 10; d++) {
						rev[i + j + k + d] = 1000 * d + 100 * c + 10 * b + a;
					}
				}
			}
		}

		// n = 10_000*a + 1_000*b + 100*c + 10*d + e =>
		// rev(n) = 10_000*e + 1_000*d + 100*c + 10*b + a
		for (int i = 10000, a = 1; a < 10; i += 10000, a++) {
			for (int j = 0, b = 0; b < 10; j += 1000, b++) {
				for (int k = 0, c = 0; c < 10; k += 100, c++) {
					for (int l = 0, d = 0; d < 10; l += 10, d++) {
						for (int e = 0; e < 10; e++)
							rev[i + j + k + l + e] = e * 10_000 + 1000 * d + 100 * c + 10 * b + a;
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		new LuckyTickets();

	}
}
