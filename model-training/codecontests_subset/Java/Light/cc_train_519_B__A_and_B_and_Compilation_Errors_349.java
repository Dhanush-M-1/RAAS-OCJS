import java.util.Scanner;

public class CompilationErrorsTest {

	public static void main(String[] args) {
		int n;
		
		int first = 0;
		int second = 0;
		int third = 0;
		
		Scanner in = new Scanner(System.in);
		try{
			n = in.nextInt();
			for(int i = 0; i < n; i++){
				first += in.nextInt();
			}
			for(int i = 0; i < n - 1; i++){
				second += in.nextInt();
			}
			for(int i = 0; i < n - 2; i++){
				third += in.nextInt();
			}
			System.out.println((first - second) + " " + (second - third));
		}finally{
			in.close();
		}
	}

}