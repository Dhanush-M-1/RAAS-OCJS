import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String ans = "NO";
		if(s.substring(0, 7).equals("keyence") || s.substring(s.length()-7, s.length()).equals("keyence")) {
			ans = "YES";
		}else if(s.substring(0, 1).equals("k") && s.substring(s.length()-6, s.length()).equals("eyence")) {
			ans = "YES";
		}else if(s.substring(0, 2).equals("ke") && s.substring(s.length()-5, s.length()).equals("yence")) {
			ans = "YES";
		}else if(s.substring(0, 3).equals("key") && s.substring(s.length()-4, s.length()).equals("ence")) {
			ans = "YES";
		}else if(s.substring(0, 4).equals("keye") && s.substring(s.length()-3, s.length()).equals("nce")) {
			ans = "YES";
		}else if(s.substring(0, 5).equals("keyen") && s.substring(s.length()-2, s.length()).equals("ce")) {
			ans = "YES";
		}else if(s.substring(0, 6).equals("keyenc") && s.substring(s.length()-1, s.length()).equals("e")) {
			ans = "YES";
		}
		System.out.println(ans);
		sc.close();
	}
}