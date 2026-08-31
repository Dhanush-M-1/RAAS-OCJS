import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		for (String str; (str=br.readLine()) != null; ) {
			String[] data = str.split(",");

			double xa = Double.parseDouble(data[0]);
			double ya = Double.parseDouble(data[1]);

			double xb = Double.parseDouble(data[2]);
			double yb = Double.parseDouble(data[3]);

			double xc = Double.parseDouble(data[4]);
			double yc = Double.parseDouble(data[5]);

			double xd = Double.parseDouble(data[6]);
			double yd = Double.parseDouble(data[7]);
			/*
			 * vector ab : (xb-xa, yb-ya)
			 * vector ac
			 * vector ad
			 * vector bc : (xc-xb, yc-yb)
			 * vector ba
			 * vector bd
			 * vector cd : (xd-xc, yd-yc)
			 * vector ca
			 * vector cb
			 */
			Vector2d a = new Vector2d(xa, ya);
			Vector2d b = new Vector2d(xb, yb);
			Vector2d c = new Vector2d(xc, yc);
			Vector2d d = new Vector2d(xd, yd);
			if ( isSameSide(a, b, c, d)
					&& isSameSide(b, c, d, a)
					&& isSameSide(c, d, a, b) ) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static class Vector2d {
		private double x;
		private double y;

		public Vector2d(double x, double y) {
			this.x = x;
			this.y = y;
		}
		// vecotr this - v
		public Vector2d minus(Vector2d v) {
			return new Vector2d(this.x - v.x, this.y - v.y);
		}
		// outerProduct this x b
		public double op(Vector2d b) {
			return this.x * b.y  -  this.y * b.x;
		}
	}
	/*
	 * outerProduct
	 * a = (a.x, a.y)
	 * b = (b.x, b.y)
	 */
//	public static double op(Vector2d a, Vector2d b) {
//		return a.x * b.y  -  a.y * b.x;
//	}

	// line ab, point c, point d
	public static boolean isSameSide(
			Vector2d a, Vector2d b, Vector2d c, Vector2d d) {
		Vector2d ab = b.minus(a);
		Vector2d ac = c.minus(a);
		Vector2d ad = d.minus(a);
//		if ( op(ab, ac) > 0 && op(ab, ad) > 0 ) {
		if ( ab.op(ac) > 0 && ab.op(ad) > 0 ) {
			return true;
//		} else if ( op(ab, ac) < 0 && op(ab, ad) < 0 ) {
		} else if ( ab.op(ac) < 0 && ab.op(ad) < 0 ) {
			return true;
		} else {
			return false;
		}
	}

}