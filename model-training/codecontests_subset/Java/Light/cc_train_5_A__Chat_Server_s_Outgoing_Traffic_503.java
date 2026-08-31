import java.util.Scanner;

public class P005A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ppl = 0;
		int total = 0;
		while (sc.hasNextLine()){
			String s = sc.nextLine();
			if (s.charAt(0) == '+')
				ppl++;
			else if (s.charAt(0) == '-')
				ppl--;
			else if (!s.endsWith(":"))
				total += ppl*s.split(":")[1].length();	
		}
		System.out.println(total);
	}

}
