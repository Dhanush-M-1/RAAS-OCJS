import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	private	static	BufferedReader	m_stdin = null;

	static {
		m_stdin = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (parseMatrix());
	}

	private static boolean parseMatrix() {
		boolean	loop = false;
		String	line = null;

		try {
			line = m_stdin.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			line = null;
		}

		if (line != null) {
			if (!line.isEmpty()) {
				String[]	lines = line.split(",");
				double[]	da    = { Double.parseDouble(lines[0]), Double.parseDouble(lines[1]) };
				double[]	db    = { Double.parseDouble(lines[2]), Double.parseDouble(lines[3]) };
				double[]	dc    = { Double.parseDouble(lines[4]), Double.parseDouble(lines[5]) };
				double[]	dd    = { Double.parseDouble(lines[6]), Double.parseDouble(lines[7]) };
				int			n1    = getCrossSign(da, db, dd);
				int			n2    = getCrossSign(db, dc, da);
				int			n3    = getCrossSign(dc, dd, db);
				int			n4    = getCrossSign(dd, da, dc);

				if ((n1 == n2) && (n2 == n3) && (n3 == n4)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}

				loop = true;
			}
		}

		return loop;
	}

	private static int getCrossSign(double[] da, double[] db, double[] dp) {
		double[]	dab = { db[0] - da[0], db[1] - da[1] };
		double[]	dap = { dp[0] - da[0], dp[1] - da[1] };
		return ( getCross(dab, dap) >= 0.0 ) ? 1 : -1;
	}

	private static double getCross(double[] d1, double[] d2) {
		return d1[0] * d2[1] - d1[1] * d2[0];
	}
}