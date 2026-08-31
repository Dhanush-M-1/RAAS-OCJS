import java.util.*;

public class Main{
	static int a, b, c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		for(int t = 0; t <= (int)(1e6); t++){
			if(check(t)){
				System.out.println(t);
				System.exit(0);
			}
		}
		//System.out.println("No Solution");
	}

	public static boolean check(int t){
		for(int t0 = t; t0 <= c + t; t0++){
			if((a - b) * t0 > a * t)
				return false;
		}
		return true;
	}
}