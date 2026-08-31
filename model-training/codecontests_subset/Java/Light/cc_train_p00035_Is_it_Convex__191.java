import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static double xa,ya,xb,yb,xc,yc,xd,yd;
	static String strArray[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;


		while((str=br.readLine()) != null){
			strArray = str.split(",");
			initialize();

			double jac = closs(xa, ya, xc, yc, xd, yd);
			double jca = closs(xc, yc, xa, ya, xb, yb);
			double jbd = closs(xb, yb, xd, yd, xa, ya);
			double jdb = closs(xd, yd, xb, yb, xc, yc);

			if((jac>0 && jca>0 && jbd>0 && jdb>0) || (jac<0 && jca<0 && jbd<0 && jdb<0)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}

		}

	}

	static double closs(double x1, double y1, double x2, double y2, double xp, double yp){
		return ( (y2-y1)*xp + (x1-x2)*yp + x2*y1 - x1*y2);
	}

	private static void initialize() {
		xa = Double.parseDouble(strArray[0]);
		ya = Double.parseDouble(strArray[1]);
		xb = Double.parseDouble(strArray[2]);
		yb = Double.parseDouble(strArray[3]);
		xc = Double.parseDouble(strArray[4]);
		yc = Double.parseDouble(strArray[5]);
		xd = Double.parseDouble(strArray[6]);
		yd = Double.parseDouble(strArray[7]);
	}
}