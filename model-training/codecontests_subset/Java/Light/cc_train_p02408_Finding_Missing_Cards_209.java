import java.io.IOException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		Object[][] array = new Object[4][13];

		for(int i=0;i<x;i++) {
			String mark = sc.next();
			int num = sc.nextInt();

			if(mark.equals("S")) {
				array[0][num-1] = num;
			}else if(mark.equals("H")) {
				array[1][num-1] = num;
			}else if(mark.equals("C")) {
				array[2][num-1] = num;
			}else if(mark.equals("D")) {
				array[3][num-1] = num;
			}
		}

		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				if(array[i][j]==null) {
					if(i==0) {
						System.out.println("S " + (j+1));
					}else if(i==1) {
						System.out.println("H " + (j+1));
					}else if(i==2) {
						System.out.println("C " + (j+1));
					}else if(i==3) {
						System.out.println("D " + (j+1));
					}
				}
			}
		}
		sc.close();
	}
}
