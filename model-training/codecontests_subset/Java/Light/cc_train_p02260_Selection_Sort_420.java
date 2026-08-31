import java.util.Scanner;

public class Main{

	public static void main(String args[]){
		new Main().mainrun();
	}

	private Scanner scan;
	private int n,count;
	private int[] A;



	public void mainrun() {
		scan = new Scanner(System.in);

		n = scan.nextInt();
		A = new int[n];
		count = 0;
		for(int i = 0;i < n ; i++) {
			A[i] = scan.nextInt();
		}

		serectionSort();

		for(int i = 0;i < n;i++) {
			String s = Integer.toString(A[i]);
			if(i != n - 1) {
				s += " ";
			}else {
				s += "\n";
			}
			System.out.print(s);
		}

		System.out.println(count);
	}

	public void serectionSort() {
		for(int i = 0; i < n;i++) {
			int minj = i;
			for(int j = i;j < n;j++) {
				if(A[j] < A[minj]) {
					minj = j;
				}

			}

			if(i != minj) {
				int tmp = A[i];
				A[i] = A[minj];
				A[minj] = tmp;
				count++;
			}

		}
	}


}
