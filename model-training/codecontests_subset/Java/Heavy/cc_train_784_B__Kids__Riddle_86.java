import java.io.IOException;
import java.util.Scanner;

public class Kids_Riddle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int hi = in.nextInt();
		//int hi = 13;
		String temp = Integer.toHexString(hi);
		//System.out.println(temp);
		int res=0;
		for (int i = 0; i < temp.length(); i++) {
			String temptemp = temp.substring(i,i+1);
			if (((temptemp.equals("0") || temptemp.equals("4")) || (temptemp.equals("6") || temptemp.equals("9"))) || (temptemp.equals("a") || temptemp.equals("d"))) {
				res++;
			} else if (temptemp.equals("8") || temptemp.equals("b")) {
				res+=2;
			}
		}
		System.out.println(res);
	}

}
