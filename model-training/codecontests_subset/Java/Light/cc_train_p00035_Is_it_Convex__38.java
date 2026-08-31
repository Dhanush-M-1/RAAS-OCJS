/**
 * 
 */
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
/**
 * @author afterCmidday
 *
 */
class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		final double eps = 1e-100;
		Scanner scan = new Scanner(System.in);
		double[] x = new double[4], y = new double[4];
		while(scan.hasNext()){
			String str = scan.next();
			for(int i = 0;i < 4;i++){
				x[i] = Double.parseDouble(str.substring(0,str.indexOf(",")));
				str = str.substring(str.indexOf(",") + 1);
				if(str.indexOf(",") == -1){
					y[i] = Double.parseDouble(str.substring(0,str.length()));
					str = str.substring(str.indexOf(",") + 1);
				}else{
					y[i] = Double.parseDouble(str.substring(0,str.indexOf(",")));
					str = str.substring(str.indexOf(",") + 1);
				}
			}
			boolean b1 = true, b2 = true;
			for(int i = 0;i < 4;i++){
				double vax = x[(i + 1) % 4] - x[i], vay = y[(i + 1) % 4] - y[i];
				double vbx = x[(i + 3) % 4] - x[i], vby = y[(i + 3) % 4] - y[i];
				if(vax * vby - vay * vbx < 0){
					b1 = false;
				}else{
					b2 = false;
				}
			}
			if(b1 || b2){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
	}

}