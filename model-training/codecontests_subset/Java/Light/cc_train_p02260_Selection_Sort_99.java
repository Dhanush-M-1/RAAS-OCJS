import java.util.Scanner;
	public class Main {
	private static Scanner scanner;
	public static void main(String args[]) {

		scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[] b = new int[a];
		int minj,count = 0;
		for(int i=0;i < a;i++) b[i] = scanner.nextInt();

		for(int i = 0;i < a;i++) {
			minj = i;
			for(int j = i;j < a;j++) {
				if(b[j] < b[minj]) {
					minj = j;
				}
			}
				if(minj != i) {
					int tmp = b[i];
					b[i] = b[minj];
					b[minj] = tmp;
					count++;
				}
		}
		for(int i=0;i < a;i++) {
			System.out.print(b[i]);
			if(i == a-1) System.out.println("");
			else System.out.print(" ");
		}
		System.out.println(count);
	}
	}

