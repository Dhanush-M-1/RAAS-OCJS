import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
public class C{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder str = new StringBuilder();
		while(t-- > 0){
			int n = in.nextInt();
			
			str.append(1D * Math.cos(Math.PI/n/4) / Math.sin(Math.PI/n/2) + "\n");
		}
		System.out.println(str.toString());
	}
}