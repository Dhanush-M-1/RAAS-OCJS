import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XORinacci {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for (int i = 0; i < cases; i++) {
			String[] chain = br.readLine().split(" ");
			int a = Integer.parseInt(chain[0]);
			int b = Integer.parseInt(chain[1]);
			int n = Integer.parseInt(chain[2]);
			System.out.println(function(a, b, n));
		}
	}

	private static int function(int a, int b, int n) {
		int num;
		switch (n%3){
        case 0:
        	num = a;
          break;
        case 1:
          num = b;
          break;
        default:
          num = a^b;
		}
		return num;
	}

}
