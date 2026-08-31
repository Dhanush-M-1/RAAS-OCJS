import java.util.Scanner;

public class Main {
	private Scanner sc;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String[] param = sc.nextLine().split(",");

			double[] x = new double[4];
			double[] y = new double[4];

			for (int i = 0; i < x.length; i++) {
				x[i] = Double.parseDouble(param[0 + i * 2]);
				y[i] = Double.parseDouble(param[1 + i * 2]);
			}
			
			boolean flag = true;
			for (int i = 0; i < x.length; i++) {
				int p = i;
				int q = (i + 1) % x.length;
				
				int r = (i + 2) % x.length;
				int s = (i + 3) % x.length;

				double dx = x[q] - x[p];
				double dy = y[q] - y[p];

				double e0;
				double e1;
				
				if (dx == 0.0) {
					e0 = x[r] - x[p];
					e1 = x[s] - x[p];
				} else if (dy == 0.0) {
					e0 = y[r] - y[p];
					e1 = y[s] - y[p];
				} else {
					double a = (y[q] - y[p]) / (x[q] - x[p]);
					double b = y[p] - a * x[p];
	
					e0 = a * x[r] + b - y[r];
					e1 = a * x[s] + b - y[s];
				}
				if (!(((e0 > 0.0) && (e1 > 0.0)) || ((e0 < 0.0) && (e1 < 0.0)))) flag = false;
			}

			if (flag == true) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}