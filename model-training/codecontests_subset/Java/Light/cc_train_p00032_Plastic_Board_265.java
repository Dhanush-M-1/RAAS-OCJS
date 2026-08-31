import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String str;
		int sq = 0, hi = 0;
		
		int a, b, c;
		
		while(scan.hasNext()){
			str = scan.next();
			String[] num = str.split(",", 0);
			
			a = Integer.parseInt(num[0]);
			b = Integer.parseInt(num[1]);
			c = Integer.parseInt(num[2]);
			
			if(a*a + b*b == c*c)sq++;
			else if(a == b)hi++;
		}
		System.out.println(sq);
		System.out.println(hi);
	}
}