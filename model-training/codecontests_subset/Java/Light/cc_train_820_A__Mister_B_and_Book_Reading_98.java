import java.util.Scanner;


public class P1 {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System. in);
		int c = scanner.nextInt();
		int v0 = scanner.nextInt();
		int v1 = scanner.nextInt();
		int a = scanner.nextInt();
		int l = scanner.nextInt();
		
		int numberOfPagesCanRead = v0; 
		int readPages = v0;
		//int readOnPreviousDay = v0;
		int days = 1;
		while(readPages < c){
			numberOfPagesCanRead += a;
			numberOfPagesCanRead = Math.min(v1, numberOfPagesCanRead);
			int reread = Math.min(l, readPages);			
			int increment = (numberOfPagesCanRead - reread);
			readPages += Math.max(increment, 0);
			//readOnPreviousDay = increment;
			days++;
		}
		System.out.println(days);
	}
}
