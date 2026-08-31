import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String[] s = sc.next().split(",");
			double[] a = new double[8];
			for(int i = 0; i < 8; i++) {
				a[i] = Double.parseDouble(s[i]);
			}
			Vec OA = new Vec(a[0], a[1]);
			Vec OB = new Vec(a[2], a[3]);
			Vec OC = new Vec(a[4], a[5]);
			Vec OD = new Vec(a[6], a[7]);
			if(isIn(OA, OB, OC, OD) || isIn(OA, OB, OD, OC) || isIn(OA, OC, OD, OB)
					|| isIn(OB, OC, OD, OA)) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
		sc.close();
	}
	static boolean isIn(Vec OA, Vec OB, Vec OC, Vec OP) {
		Vec AB = new Vec(OB.x - OA.x, OB.y - OA.y);
		Vec BC = new Vec(OC.x - OB.x, OC.y - OB.y);
		Vec CA = new Vec(OA.x - OC.x, OA.y - OC.y);

		Vec AP = new Vec(OP.x - OA.x, OP.y - OA.y);
		Vec BP = new Vec(OP.x - OB.x, OP.y - OB.y);
		Vec CP = new Vec(OP.x - OB.x, OP.y - OB.y);

		double d1 = AB.x * BP.y - AB.y * BP.x;
		double d2 = BC.x * CP.y - BC.y * CP.x;
		double d3 = CA.x * AP.y - CA.y * AP.x;
		if((d1 > 0.0 && d2 > 0.0 && d3 > 0.0) || (d1 < 0.0 && d2 < 0.0 && d3 < 0.0)) {
			return true;
		}
		return false;
	}
	static class Vec{
		double x, y;
		public Vec(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}
