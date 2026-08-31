import java.util.Scanner;

class Main{
	static String remove(String s, int x, int y) {
		return s.substring(0, x) + s.substring(y + 1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean keyence = s.equals("keyence");
		for(int i = 0; i < s.length(); i++) {
			for(int j = i; j < s.length(); j++) {
				if(remove(s, i, j).equals("keyence")) keyence = true;
			}
		}
		System.out.println(keyence ? "YES" : "NO");
	}
}
