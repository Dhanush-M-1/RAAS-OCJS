
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	Scanner sc = new Scanner(System.in);

	void run() {
		String s = sc.next();		
		String k = "keyence";
		
		int f=0;
		int b=0;
		for(int i = 0; i < Math.min(s.length(), k.length() );i++){
			if(s.charAt(i) == k.charAt(i)){
				f++;
			}else{
				break;
			}
		}

		for(int i = 0; i < Math.min(s.length(), k.length() );i++){
			if(s.charAt(s.length()-i-1) == k.charAt(k.length()-i-1)){
				b++;
			}else{
				break;
			}
		}

		if(f+b >= k.length()){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
	

	
}
