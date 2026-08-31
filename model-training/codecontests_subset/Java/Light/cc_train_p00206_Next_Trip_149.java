import java.util.Scanner;
class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int l, m, n;
		int i, ct;
		
		while ((l = input.nextInt()) != 0){
			ct = 0;
			for (i = 0; i < 12; i++){
				m = input.nextInt();
				n = input.nextInt();
				if (l > 0){
					l -= (m - n);
					ct++;
				}
			}
			if (l > 0){
				System.out.println("NA");
			}
			else {
				System.out.println(ct);
			}
		}
	}
}