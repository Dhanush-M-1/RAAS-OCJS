import java.util.Scanner;

public class R421A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		int v0 = scan.nextInt();
		int v1 = scan.nextInt();
		int a = scan.nextInt();
		int p = scan.nextInt();
		int v = v0;
		int page = 0;
		int count = 0;
		while(page < c){
			page += Math.min(v1, v+(count*a));
			//System.out.println(page);
			count++;
			if(page >= c){
				System.out.println(count);
				return;
			}
			page -= p;
		}
	}
}
