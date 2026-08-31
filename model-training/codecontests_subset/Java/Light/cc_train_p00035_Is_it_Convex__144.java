import java.util.Scanner;

public class Main {
	
	public static double[] equation(double a,double b,double c,double d,double e,double f){
		double det = a*e-b*d;
		double[] ans = new double[2];
		double x = (c*e-b*f)/det;
		double y = (a*f-c*d)/det;
		if(x==-0)
			x = 0;
		if(y==-0)
			y = 0;
		ans[0] = x;
		ans[1] = y;
		return ans;
	}
	
	public static String[] kommmaReader(String sc) {
		String line = sc;
		String[] array = line.split(",");
		return array;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			String[] str = kommmaReader(sc.nextLine());
			double[] p = new double[8];
			for(int i=0; i<8; i++) p[i] = Double.parseDouble(str[i]);
			double[] ans = equation(p[0]-p[2],p[4]-p[2],p[6]-p[2],p[1]-p[3],p[5]-p[3],p[7]-p[3]);
		
			if(ans[0]+ans[1]>1 && ans[0]>0 && ans[1]>0) System.out.println("YES");
			else System.out.println("NO");
		} while(sc.hasNext());
	}

}