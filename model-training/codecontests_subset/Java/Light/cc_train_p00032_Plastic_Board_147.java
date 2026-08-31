import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[\n ,]");
		int rect = 0;
		int loz = 0;
		
		while(sc.hasNext()){
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y = sc.nextInt();
			rect = (x1*x1 + x2*x2 == y*y) ? rect + 1 : rect;
			loz = ((x1*x1 == x2*x2)&&(x1+x2>y)) ? loz + 1: loz;
		}
		System.out.printf("%d\n%d\n",rect,loz);
		sc.close();
	}
}