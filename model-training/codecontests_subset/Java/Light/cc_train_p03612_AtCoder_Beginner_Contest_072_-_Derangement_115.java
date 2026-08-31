import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0;i < n;i++) {
			array[i] = sc.nextInt();
		}
		int answer = 0;
		boolean sameFlag = false;
		for(int i = 0;i < n;i++) {
			if(i +1 == array[i]) {
				if(sameFlag) {
					sameFlag = false;
				}else {
					answer++;
					sameFlag = true;
				}

			}else {
				sameFlag = false;
			}
		}
		System.out.println(answer);
	}
}