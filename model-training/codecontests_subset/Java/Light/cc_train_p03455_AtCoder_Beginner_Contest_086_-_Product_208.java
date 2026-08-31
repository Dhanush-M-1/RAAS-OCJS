import java.util.*;
// warm-up
public class Main {

	static void solve() {
		Scanner sc = new Scanner(System.in);
		System.out.println(((sc.nextInt()*sc.nextInt())&1)==0 ? "Even" : "Odd");
		sc.close();		
	}

	public static void main(String args[]) {
		solve();
	}

}