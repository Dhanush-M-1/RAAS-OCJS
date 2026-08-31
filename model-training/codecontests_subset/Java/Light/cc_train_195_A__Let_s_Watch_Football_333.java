import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if (b>=a) {
			System.out.println("0");
			System.exit(0);
		}
		
		int totalSize = a*c;
		int maxTime = (int) Math.ceil(totalSize*1.0/b);
		
		int minTime = -1;
		for (int i=1; i<=maxTime; i++) {
			if (b*i >= a || (a - b*i <= b) ) {
				minTime = i;
				break;
			}
		}
		
		//System.out.println(minTime);
		
		for (int i=minTime; i<= maxTime; i++) {
			int downloaded = b*i;
			int downloadNeeded = 0;
			while (downloadNeeded<=downloaded && downloaded<=totalSize) {
				downloadNeeded += a;
				downloaded += b;
			}
			if (downloaded>=totalSize) {
				System.out.println(i);
				System.exit(0);
			}
		}
		
	}
}
