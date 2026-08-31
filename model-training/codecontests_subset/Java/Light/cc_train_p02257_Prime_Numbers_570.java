import java.util.Scanner;

class Main {
	int count;
	public static void main(String[] args) {
		Main pmClass = new Main();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
			pmClass.calc(array[i]);
		}
		System.out.println(pmClass.count);
	}
	public void calc(int a){
		boolean pm = true;
		if(a <= 1 || a % 2 == 0) {
			pm = false;
		}
		if(a == 2) {
			pm = true;
		}
		for(int i = 3; i <= Math.sqrt(a); i += 2) {
			if (a % i == 0) {
				pm = false;
				break;
			}
		}
		if (pm) count++;
	}
}
