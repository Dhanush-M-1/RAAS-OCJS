import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k0 = 0;
		int k1 = 0;
		while(sc.hasNext()) {
			String s = sc.next();
			String[] n = s.split(",");
			int a = Integer.parseInt(n[0]);
			int b = Integer.parseInt(n[1]);
			int c = Integer.parseInt(n[2]);
			if(a * a + b * b == c * c && a == b) continue;
			if(a * a + b * b == c * c && a != b) {
				k0++;
			}else if(a == b){
				k1++;
			}
		}
		sc.close();
		System.out.println(k0);
		System.out.println(k1);
	}
}
