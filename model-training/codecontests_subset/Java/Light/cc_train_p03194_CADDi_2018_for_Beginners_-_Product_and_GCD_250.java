import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String[] l = str.split(" ");
		long N = Long.parseLong(l[0]);
		long P = Long.parseLong(l[1]);
		long tempP = P;
		long startP = Math.round(Math.pow(P, 1.0/N))+1;
		for (long j = startP; j > 0; j--) {
			tempP = P;
			if (Math.floorMod(tempP, Math.round(Math.pow(j, N))) == 0L) {
				System.out.println(j);
				return;
			}
		}
	}
}