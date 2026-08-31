import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		sc.close();
		if( ((r1 - d2 + c1) % 2 == 0) &&  (r1 - d2 + c1) > 0
				&& ((c2 + d2 - r2) % 2 == 0) && (c2 + d2 - r2) > 0
				&& ((r2 + d2 - c2) % 2 == 0) && (r2 + d2 - c2) > 0
				&& ((r2 - c1 + d1) % 2 == 0) && (r2 - c1 + d1) > 0){
			Set <Integer> a = new HashSet <>();
			if((r1 - d2 + c1)/2 <= 9) a.add((r1 - d2 + c1)/2);
			if((c2 + d2 - r2)/2 <= 9) a.add((c2 + d2 - r2)/2);
			if((r2 + d2 - c2)/2 <= 9) a.add((r2 + d2 - c2)/2);
			if((r2 - c1 + d1)/2 <= 9) a.add((r2 - c1 + d1)/2);
			if(a.size() == 4){
				System.out.println((r1 - d2 + c1)/2 + " " + (c2 + d2 - r2)/2 
						+"\n" + (r2 + d2 - c2)/2 + " " + (r2 - c1 + d1)/2);
			}
			else{
				System.out.println(-1);
			}
		}
		else{
			System.out.println(-1);
		}
	}
}