import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf;

		try {
			while ((buf = br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(buf,",");
				double x[] = new double[4];
				double y[] = new double[4];
				boolean flag = false;

				for (int i=0;i<4;i++) {
					x[i] = Double.parseDouble(st.nextToken());
					y[i] = Double.parseDouble(st.nextToken());
				}

				if (S(x[0],y[0],x[1],y[1],x[2],y[2])>0) {
					for (int i=1;i<4;i++)
						if (S(x[i%4],y[i%4],x[(i+1)%4],y[(i+1)%4],x[(i+2)%4],y[(i+2)%4])<0) {
							flag = true;
						}
				} else {
					for (int i=1;i<4;i++)
						if (S(x[i%4],y[i%4],x[(i+1)%4],y[(i+1)%4],x[(i+2)%4],y[(i+2)%4])>0) {
							flag = true;
						}
				}

				if (flag) System.out.println("NO");
				else System.out.println("YES");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double S(double x1,double y1,double x2,double y2,double x3,double y3) {
		return (x2-x1)*(y3-y1)-(x3-x1)*(y2-y1);
	}
}