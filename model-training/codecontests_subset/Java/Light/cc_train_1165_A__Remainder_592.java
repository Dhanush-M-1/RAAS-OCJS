import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
		String s = sc.next();
		
		int sum = 0;
		if(s.charAt(s.length() - y - 1) == '0')
			sum++;
		
		for(int i = 0; i < x; i++) {
			if(i == y)
				continue;
			if(s.charAt(s.length() - i - 1) == '1')
				sum++;
		}
		
		System.out.println(sum);
	}
}
