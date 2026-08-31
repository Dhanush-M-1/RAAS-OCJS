import java.util.Scanner;

public class MisterBAndBookReading {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().split(" ");
		in.close();
		int c = Integer.parseInt(input[0]);
		int v0 = Integer.parseInt(input[1]);
		int v1 = Integer.parseInt(input[2]);
		int a = Integer.parseInt(input[3]);
		int l = Integer.parseInt(input[4]);
		
		int days = 0;
		int page = 0;
		while(page < c) {
			days++;
//			System.out.println("Days = "+days);
//			System.out.println("Speed = "+Math.min(v0+a*(days-1), v1));
			if(days > 1) {
				page -= Math.min(l, Math.min(v0+a*(days-1), v1));
//				System.out.println("Rereading last "+Math.min(l, Math.min(v0+a*(days-1), v1))+" pages.");
				
			}
			page += Math.min(v0+a*(days-1), v1);
		}
		System.out.println(days);
	}

}
