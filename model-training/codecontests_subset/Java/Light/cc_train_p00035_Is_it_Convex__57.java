import java.util.*;

public class Main{
	
	private static final Scanner scan = new Scanner(System.in)
							.useDelimiter("[,\\s]+");
	static boolean dirs[] = new boolean[4];

	public static void main(String[] args){
		
		while(scan.hasNext()){
			double[] x = new double[4];
			double[] y = new double[4];
			for(int i = 0; i < 4; i++){
				x[i] = scan.nextDouble();
				y[i] = scan.nextDouble();
			}
			System.out.println(solve(x,y));
		}
	}

	static String solve(double[] x, double[] y){
		for(int i = 0; i < 4; i++){
			int j = (i+1) % 4;
			int k = (i+2) % 4;
			dirs[i] = cross(x[j]-x[i], y[j]-y[i], x[k]-x[i], y[k]-y[i]);
		}
		boolean yes = true;
		for(int i = 1; i < 4; i++){
			if(dirs[i-1] != dirs[i]){
				yes = false;
			}
		}
		return yes? "YES" : "NO";
	}

	private static boolean cross(double x1, double y1, double x2, double y2){
		return (x1*y2 - x2*y1) >= 0;
	}
}