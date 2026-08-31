import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args)throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		Main app = new Main();
		String string;
		
		while((string = reader.readLine()) != null){
			String[] source = string.split(",");
			double[] p = app.map(source);
			
			if(app.check(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7]) < 0.0 ||
			   app.check(p[4], p[5], p[6], p[7], p[0], p[1], p[2], p[3]) < 0.0)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		
		reader.close();
	}
	
	public double[] map(String[] source){
		double[] hoge = new double[8];
		for(int i = 0; i < 8; i++) hoge[i] = Double.parseDouble(source[i]);
		return hoge;
	}
	
	public double check(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
		return ((x1 - x2) * (y3 - y1) + (y1 - y2) * (x1 - x3)) * ((x1 - x2) * (y4 - y1) + (y1 - y2) * (x1 - x4));
	}
	
}