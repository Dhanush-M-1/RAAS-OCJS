import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int dish = scan.nextInt();
		int[] arrayD = new int[dish];
		int[] arrayM = new int[dish];
		int[] arrayA = new int[dish-1];
		int sum = 0;

		for(int i=0;i<dish;i++) {
			arrayD[i] = scan.nextInt();

		}
		for(int i=0;i<dish;i++) {
			arrayM[i] = scan.nextInt();
			sum += arrayM[i];
		}
		for(int i=0;i<dish-1;i++) {
			arrayA[i] = scan.nextInt();
		}
		for(int i=1;i<dish;i++) {
			if(arrayD[i-1]+1==arrayD[i]) {
				sum += arrayA[arrayD[i-1]-1];
			}
		}
		System.out.println(sum);
		scan.close();
	}

}
