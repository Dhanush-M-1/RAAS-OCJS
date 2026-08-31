import java.util.*;

public class Main{
	
	private static final Scanner scan = new Scanner(System.in)
							.useDelimiter("[,\\s]+");

	public static void main(String[] args){

		while(scan.hasNext()){
			double[] x = new double[4];
			double[] y = new double[4];
			for(int i = 0; i < 4; i++){
				x[i] = scan.nextDouble();
				y[i] = scan.nextDouble();
			}
			boolean flag = isIntersect(x[0], y[0], x[2], y[2], x[1], y[1], x[3], y[3])
			 && isIntersect(x[1], y[1], x[3], y[3], x[0], y[0], x[2], y[2]);
			System.out.printf("%s\n", flag? "YES" : "NO");
		}
	}

	public static boolean isIntersect(double x1, double y1, double x2, double y2,
					 double x3, double y3, double x4, double y4){
		boolean result = false;
		double tb = (x1-x2)*(y3 -y1)+(y1-y2)*(x1- x3);
		double td = (x1-x2)*(y4 -y1)+(y1-y2)*(x1- x4);
		if(tb*td < 0){
			result = true;
		}
		return result;
	}
} 