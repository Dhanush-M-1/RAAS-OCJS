import java.util.Arrays;
import java.util.Scanner;

public class HelpMathDemo {

	public String HelpMath(String x){
		String[] a = x.split("\\+");
		int[] aint = new int[a.length];
		for(int i = 0; i < a.length; i++){
			aint[i] = Integer.valueOf(a[i]);
		}
		Arrays.sort(aint);
		String result = aint[0] + "";
		for(int i = 1; i < aint.length; i++){
			result = result + "+" + aint[i];
		}
		return result;
	}
	
	public static void main(String[] args){
		HelpMathDemo hmd = new HelpMathDemo();
		Scanner cin = new Scanner(System.in);
		
		String x;
		x = cin.next();
		System.out.println(hmd.HelpMath(x));
	}
}