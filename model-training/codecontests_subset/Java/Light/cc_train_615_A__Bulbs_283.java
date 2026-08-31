import java.util.*;
public class Bulbs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int button = Integer.parseInt(input[0]);
		boolean[] bulb = new boolean[Integer.parseInt(input[1])];
		for(int i = 0;i<button;i++) {
			input = scan.nextLine().split(" ");
			for(int j = 1;j<input.length;j++) {
				bulb[Integer.parseInt(input[j])-1]=true;
			}
		}
		boolean light = true;
		for(int i = 0;i<bulb.length;i++) {
			if(!bulb[i])light=false;
		}
		System.out.println(light?"YES":"NO");
		

	}

}
