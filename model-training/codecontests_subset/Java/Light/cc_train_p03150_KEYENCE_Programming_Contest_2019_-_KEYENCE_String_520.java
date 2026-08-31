import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader input =new BufferedReader (new InputStreamReader (System.in));
		String str = input.readLine( );
		String[] start = {"keyenc", "keyen", "keye", "key", "ke", "k"};
		String[] end = {"e", "ce", "nce", "ence", "yence", "eyence"};

		if(str.startsWith("keyence") || str.endsWith("keyence")) {
			System.out.println("YES");
		}else {
			for(int i=0; i<6; i++) {
				if(str.startsWith(start[i]) && str.endsWith(end[i])) {
					System.out.println("YES");
					break;
				}
				if(i==5) {
					System.out.println("NO");
				}
			}

		}
	}

}
