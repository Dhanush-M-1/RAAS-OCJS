import java.util.Scanner;


public class May_1 {
	
	public static void main(String [] args) {
		f805_a();
	}
	
	public static void f805_a() {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int r = in.nextInt();
		int two = 0;
		int three = 0;
		for(int i = l; i<=r; i++) {
			if(i%2 == 0)
				two++;
			if(i%3 == 0)
				three++;
			if(two == 2) {
				System.out.println(2);
				return;
			}
			if(three == 2) {
				System.out.println(3);
				return;
			}
		}
		System.out.println(l);
	}
	
	public static void f805_c() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int min = 1;
		int max = n;
		long res = 0;
		int current = 1;
		for(int i=0; i<n-1; i++) {
			if(min >= max)
				break;
			if(current == min) {
				res += (min+max) % (n+1);
				current = max;
				min++;
			} 
			else if(current == max) {
				res += (min+max) % (n+1);
				current = min;
				max--;
			}
		}
		System.out.println(res);
		
	}
	
	public static void f805_b() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int flag = 0;
		for(int i=0; i<n; i++) {
			if(flag == 0)
				System.out.print("a");
			if(flag == 1)
				System.out.print("a");
			if(flag == 2)
				System.out.print("b");
			if(flag == 3)
				System.out.print("b");
			flag++;
			if(flag > 3) flag = 0;
		}
		System.out.println();
		
	}

}
