
import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ


		Scanner scan = new Scanner(in);

		while(scan.hasNext()){
			String[] t = scan.next().split(",");
			double[] x = new double[4];
			double[] y = new double[4];
			x[0] = Double.parseDouble(t[0]);
			y[0] = Double.parseDouble(t[1]);
			x[1] = Double.parseDouble(t[2]);
			y[1] = Double.parseDouble(t[3]);
			x[2] = Double.parseDouble(t[4]);
			y[2] = Double.parseDouble(t[5]);
			x[3] = Double.parseDouble(t[6]);
			y[3] = Double.parseDouble(t[7]);

			double[] r = new double[4];

			for(int i=0;i<4;i++){
				double a2 = pow(x[(i+1)%4]-x[i],2)+pow(y[(i+1)%4]-y[i],2);
				double b2 = pow(x[(i+2)%4]-x[(i+1)%4],2)+pow(y[(i+2)%4]-y[(i+1)%4],2);
				double c2 = pow(x[i]-x[(i+2)%4],2)+pow(y[i]-y[(i+2)%4],2);

				r[i] = acos((a2+b2-c2)/(sqrt(a2*b2)*2));
			}

			if((r[0]+r[1]+r[2]+r[3])<PI*2)
				out.println("NO");
			else
				out.println("YES");
		}
	}

}