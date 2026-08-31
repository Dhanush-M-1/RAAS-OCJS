import java.util.Scanner;
import java.io.*;

public class Main{
	public static String solve(double[] p){
		double a = p[4]-p[0]; //  c-a
		double b = p[6]-p[2]; //  g-e
		double c = p[5]-p[1]; //  d-b
		double d = p[7]-p[3]; //  h-f
		double e = p[3]*p[6]-p[2]*p[7]; //  fg-eh
		double f = p[0]*p[5]-p[1]*p[4]; //  ad-bc
		
		if( a == 0 ){
			double key = (d/b)*(p[0]-p[2])+p[3];
			if( (key-p[1])*(key-p[5]) < 0 && (p[0]-p[2])*(p[0]-p[6]) < 0 ){
				return "YES";
			} else {
				return "NO";
			}
		} else if( b == 0 ){
			double key = (c/a)*(p[2]-p[0])+p[1];
			if( (key-p[3])*(key-p[7]) < 0 && (p[2]-p[0])*(p[2]-p[4]) < 0 ){
				return "YES";
			} else {
				return "NO";
			}
		} else {
			double key = (a*e+b*f)/(-a*d+c*b);
			if( (key-p[0])*(key-p[4]) <= 0 && (key-p[2])*(key-p[6]) <= 0 ){
				return "YES";
			} else {
				return "NO";
			}
		}
	}
			
	public static void main(String[] args) throws IOException{
		Scanner stdIn = null;
		String[] result = new String[10000];
		int index = 0;
		
		try{
			stdIn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			while( stdIn.hasNext() ){
				String str = stdIn.next();
				String[] s = str.split(",");
				double[] p = new double[s.length];
				for(int i = 0; i < s.length; i++){
					p[i] = Double.parseDouble(s[i]);
				}
				result[index] = solve(p);
				index++;
			}
			for(int i = 0; i < index; i++){
				System.out.println(result[i]);
			}
		} finally {
			if( stdIn != null ){
				stdIn.close();
			}
		}
	}
}