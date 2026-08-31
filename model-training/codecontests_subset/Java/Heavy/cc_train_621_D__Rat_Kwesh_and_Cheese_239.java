import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.String;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		PrintWriter writer= new PrintWriter(System.out);
		String line = reader.nextLine();
		String[] strs = line.split("\\s+");
		double[] para = new double[3];
		for(int j = 0; j <3; j++){
			for(int i = 0; i <strs[j].length()-1;i++){
				if(strs[j].charAt(i) == '.'){
					int k = Integer.parseInt(strs[j].substring(i+1));
					int q = Integer.parseInt(strs[j].substring(0, i));
					para[j] = q + k/10.0;
				}
			}
		}
		double x = para[0];
		double y = para[1];
		double z = para[2];
		String[] result = new String[] {"x^y^z", "x^z^y", "(x^y)^z", "y^x^z", "y^z^x", "(y^x)^z", "z^x^y", "z^y^x", "(z^x)^y"};
		if(x <= 1&&y<=1&&z<=1) writer.println(result[ThreeSmall(x,y,z)-1]);
		if(x > 1 && y>1 && z>1) writer.println(result[ThreeBig(x,y,z)-1]);
		if(x <= 1 && y> 1 && z>1){
			double[] compare = new double[6];
			compare[0] = z*Math.log(x)+Math.log(Math.log(y));
			compare[1] = x*Math.log(z)+Math.log(Math.log(y));
			compare[2] = Math.log(x*z)+Math.log(Math.log(y));
			compare[3] = y*Math.log(x) + Math.log(Math.log(z));
			compare[4] = x*Math.log(y) + Math.log(Math.log(z));
			compare[5] = Math.log(x*y) + Math.log(Math.log(z));
			int index = 0;
			double max = compare[0];
			for(int i = 1; i < 6; i++){
				if(compare[i] > max){
					max = compare[i];
					index = i;
				}
			}
			writer.println(result[index+3]);
		}
		if(y <= 1 && x> 1 && z>1){
			double[] compare = new double[6];
			compare[0] = z*Math.log(y)+Math.log(Math.log(x));
			compare[1] = y*Math.log(z)+Math.log(Math.log(x));
			compare[2] = Math.log(y*z)+Math.log(Math.log(x));
			compare[3] = y*Math.log(x) + Math.log(Math.log(z));
			compare[4] = x*Math.log(y) + Math.log(Math.log(z));
			compare[5] = Math.log(x*y) + Math.log(Math.log(z));
			int index = 0;
			double max = compare[0];
			for(int i = 1; i < 6; i++){
				if(compare[i] > max){
					max = compare[i];
					index = i;
				}
			}
			if(index < 3) writer.println(result[index]);
			else writer.println(result[index+3]);
		}
		if(z<=1 &&x>1&&y>1){
			double[] compare = new double[6];
			compare[0] = z*Math.log(y)+Math.log(Math.log(x));
			compare[1] = y*Math.log(z)+Math.log(Math.log(x));
			compare[2] = Math.log(y*z)+Math.log(Math.log(x));
			compare[3] = z*Math.log(x) + Math.log(Math.log(y));
			compare[4] = x*Math.log(z) + Math.log(Math.log(y));
			compare[5] = Math.log(x*z) + Math.log(Math.log(y));
			int index = 0;
			double max = compare[0];
			for(int i = 1; i < 6; i++){
				if(compare[i] > max){
					max = compare[i];
					index = i;
				}
			}
			writer.println(result[index]);
		}
		if(x<=1&&y<=1&&z>1){
			double mot = Math.pow(x,y)*Math.log(z);
			double hai = Math.pow(y,x)*Math.log(z);
			double ba = y*x*Math.log(z);
			if(mot >= hai && mot >= ba) writer.println(result[6]);
			else if(hai >= ba) writer.println(result[7]);
			else writer.println(result[8]);
			
		}
		if(x<=1 &&z<=1&&y>1){
			double mot = Math.pow(x,z)*Math.log(y);
			double hai = Math.pow(z,x)*Math.log(y);
			double ba = z*x*Math.log(y);
			if(mot >= hai && mot >= ba) writer.println(result[3]);
			else if(hai >= ba) writer.println(result[4]);
			else writer.println(result[5]);
			//writer.println(result[oneBig2small(y,z,x)-1+3]);
		}
		if(x>1&&y<=1&&z<=1){
			double mot = Math.pow(y,z)*Math.log(x);
			double hai = Math.pow(z,y)*Math.log(x);
			double ba = z*y*Math.log(x);
			if(mot >= hai && mot >= ba) writer.println(result[0]);
			else if(hai >= ba) writer.println(result[1]);
			else writer.println(result[2]);
		}
		
		//writer.println(x+" "+y+" "+z);
		reader.close();
		
		writer.flush();
		writer.close();
		
	}
	
	static int oneSmall2big(double x, double y, double z){//x is small
		double[] compare = new double[6];
		compare[0] = z*Math.log(x)+Math.log(Math.log(y));
		compare[1] = x*Math.log(z)+Math.log(Math.log(y));
		compare[2] = Math.log(x*z)+Math.log(Math.log(y));
		compare[3] = y*Math.log(x) + Math.log(Math.log(z));
		compare[4] = x*Math.log(y) + Math.log(Math.log(z));
		compare[5] = Math.log(x*y) + Math.log(Math.log(z));
		int result = 0;
		double max = compare[0];
		for(int i = 1; i < 6; i++){
			if(compare[i] > max){
				max = compare[i];
				result = i;
			}
		}
		return result+1;
	}
	
	static int oneBig2small(double x, double y, double z){//x is big
		double mot = Math.pow(y,z)*Math.log(x);
		double hai = Math.pow(z, y)*Math.log(x);
		double ba = y*z*Math.log(x);
		if(mot >= hai && mot >= ba) return 1;
		else if(hai >= ba) return 2;
		else return 3;
	}
	
	static int ThreeBig(double x, double y, double z){
		double[] compare = new double[9];
		compare[0] = z*Math.log(y)+Math.log(Math.log(x));
		compare[1] = y*Math.log(z)+Math.log(Math.log(x));
		compare[2] = Math.log(y*z)+Math.log(Math.log(x));
		compare[3] = z*Math.log(x) + Math.log(Math.log(y));
		compare[4] = x*Math.log(z) + Math.log(Math.log(y));
		compare[5] = Math.log(x*z) + Math.log(Math.log(y));
		compare[6] = y*Math.log(x) + Math.log(Math.log(z));
		compare[7] = x*Math.log(y) + Math.log(Math.log(z));
		compare[8] = Math.log(x*y) + Math.log(Math.log(z));
		int result = 0;
		double max = compare[0];
		for(int i = 1; i < 9; i++){
			if(compare[i] > max){
				max = compare[i];
				result = i;
			}
		}
		return result+1;
	}
	
	static int ThreeSmall(double x, double y, double z){
		double[] compare = new double[9];
		compare[0] = Math.pow(x, Math.pow(y, z));
		compare[1] = Math.pow(x, Math.pow(z, y));
		compare[2] = Math.pow(x, y*z);
		compare[3] = Math.pow(y,  Math.pow(z, x));
		compare[4] = Math.pow(y,  Math.pow(x, z));
		compare[5] = Math.pow(y, x*z);
		compare[6] = Math.pow(z,  Math.pow(x,  y));
		compare[7] = Math.pow(z,  Math.pow(y,  x));
		compare[8] = Math.pow(z,  x*y);
		int result = 0;
		double max = compare[0];
		for(int i = 1; i < 9; i++){
			if(compare[i] > max){
				max = compare[i];
				result = i;
			}
		}
		return result+1;
	}

}
