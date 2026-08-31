import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B174 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = readInt(br);
		String line = br.readLine();
		int F = 0;
		int A = 0;
		int I = 0;
		for (char c : line.toCharArray()) {
			if ( c == 'A') A++;
			else if ( c == 'F') F++;
			else if ( c == 'I') I++;
		}
		
		if ( I > 1 ) {
			System.out.println("0");
		} else if (I == 1){
			System.out.println("1");
		} else {
			System.out.println(A);
		}
		
		br.close();
	}
	
	private static int readInt(BufferedReader br) throws Exception {
		return Integer.parseInt(br.readLine());
	}


}
