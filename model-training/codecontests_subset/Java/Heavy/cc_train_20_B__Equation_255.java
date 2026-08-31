import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Equation {

	/**
	 * @param args
	 */

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			String s=r.readLine();
			String[] sp=s.split(" ");
			double a=Double.parseDouble(sp[0]);
			double b=(double)Integer.parseInt(sp[1]);
			double c=(double)Integer.parseInt(sp[2]);
			double disc=b*b-4*a*c;
			if(a==0&&b==0&&c==0){
				System.out.println(-1);
				System.exit(0);
			}
			if(a==0&&b==0){
				System.out.println(0);
				System.exit(0);
			}
			if(a==0){
				System.out.println(1);
				System.out.println((double)-c/b+"00000");
				System.exit(0);
			}
			
			if(disc<0){
				System.out.println(0);
			}
			else if(disc==0){
				System.out.println(1);
				System.out.println((double) -b/(2*a)+"00000");
			}
			else { 
				System.out.println(2);
				double[] arr=new double[2];
				arr[0]=(double) (-b-Math.sqrt(disc))/(2*a);
				arr[1]=(double) (-b+Math.sqrt(disc))/(2*a);
				Arrays.sort(arr);
				System.out.println(arr[0]+"00000");
				System.out.println(arr[1]+"00000");
			}
	}

}
