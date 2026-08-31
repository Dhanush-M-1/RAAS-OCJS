import java.util.Scanner;


public class CF1165A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		String s = sc.next();
		s = s.substring(s.length()-x);
		int total = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<y; i++) sb.append("0");
		sb.append("1");
		while(sb.length()<x) sb.append("0");
		sb  = sb.reverse();
		for(int i=0; i<x; i++) if(s.charAt(i)!=sb.charAt(i)) total++;
		System.out.println(total);
	}
}
