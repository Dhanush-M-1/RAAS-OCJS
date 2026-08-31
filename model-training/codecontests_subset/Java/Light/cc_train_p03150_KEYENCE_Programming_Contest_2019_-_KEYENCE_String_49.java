import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean flag = false;
		
		for(int i=0; i<str.length(); i++) {
			for(int j=i; j<=str.length(); j++) {
				StringBuilder strs = new StringBuilder(str);
				if(strs.delete(i, j).toString().equals("keyence")) {
					flag = true;
					System.out.println("YES");
					return;
				}else {
					flag = false;
				}
			}
		}
		if(!flag) {
			System.out.println("NO");
		}
	}
}
