import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int card[][]=new int[4][13];

		for(int t=0;t<n;t++) {
			String type=sc.next();
			int num=sc.nextInt();

			if(type.equals("S")) {
				card[0][num-1]=1;
			}else if(type.equals("H")) {
				card[1][num-1]=1;
			}else if(type.equals("C")) {
				card[2][num-1]=1;
			}else {
				card[3][num-1]=1;
			}
		}

		for(int a=0;a<4;a++) {
			for(int b=0;b<13;b++) {
				if(card[a][b]!=1) {
					if(a==0) {
						System.out.println("S "+(b+1));
					}else if(a==1) {
						System.out.println("H "+(b+1));
					}else if(a==2) {
						System.out.println("C "+(b+1));
					}else if(a==3) {
						System.out.println("D "+(b+1));
					}
				}
			}
		}



	}
}



