import java.util.Arrays;
import java.util.Scanner;

/**
 * A. Helpful Maths
 * @author satyam
 *
 */
public class CodeForces12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str= sc.nextLine();
		String[] strs = str.split("\\+");
		Arrays.sort(strs);
		str="";
		for(int i=0;i<strs.length-1;i++) {
			str+=strs[i]+"+";
		}
		str+=strs[strs.length-1];
		System.out.print(str);

	}

}
