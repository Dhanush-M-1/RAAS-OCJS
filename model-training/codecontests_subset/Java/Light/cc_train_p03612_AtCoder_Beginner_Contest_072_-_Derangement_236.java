import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		try(Scanner scan = new Scanner(System.in)){

			int N = scan.nextInt();
			int[]p = new int[N];
			for(int i = 0;i<N;i++)p[i] = scan.nextInt();



			int count = 0;
			for(int i = 0;i<N;i++) {
				if(i!=N-1) {
					if(p[i]-1==i) {
						if(p[i+1]-1==i+1) {
							count++;
							i++;
						}else {
							count++;
						}
						}
				}else {
					if(p[i]-1==i) {
						count++;
					}


				}


			}


			System.out.println(count);

		}


	}


}
