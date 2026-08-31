import java.util.Scanner;

public class Main {
	private double[] pos = new double[8];

	public static void main(String[] args) {
		new Main().run();
	}
	
	private void run() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] str = scan.nextLine().split(",");
			for (int i = 0; i < 8; i++) pos[i] = Double.parseDouble(str[i]);
			
			double sum = 0;
			for (int i = 0; i < 4; i++) {
				double x1, x2, y1, y2;
				if (i == 0) {
					x1 = pos[6] - pos[i];
					y1 = pos[7] - pos[i+1];
					x2 = pos[(i + 1) * 2] - pos[i];
					y2 = pos[(i + 1) * 2 + 1] - pos[i+1];
				}else if (i == 3) {
					x1 = pos[4] - pos[6];
					y1 = pos[5] - pos[7];
					x2 = pos[0] - pos[6];
					y2 = pos[1] - pos[7];
				}else {
					x1 = pos[(i - 1) * 2] - pos[i * 2];
					y1 = pos[(i - 1) * 2 + 1] - pos[i * 2 + 1];
					x2 = pos[(i + 1) * 2] - pos[i * 2];
					y2 = pos[(i + 1) * 2 + 1] - pos[i * 2 + 1];
				}
				
				sum += calsi(x1, y1, x2, y2);
			}
			System.out.println((int)sum == 360? "YES" : "NO");
		}
	}
	
	private double calsi(double x1, double y1, double x2, double y2) {
		double a = x1 * x2 + y1 * y2;
		double b = Math.sqrt((x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2));
		double cos = a / b;
		double acos = Math.acos(cos);
		double si = Math.toDegrees(acos);
		//System.out.println(si);
		return si;
	}
	
	private void debug() {
		System.out.println();
	}

}