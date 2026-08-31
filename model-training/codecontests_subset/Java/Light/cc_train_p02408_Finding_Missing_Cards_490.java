import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int abc[][] = new int[4][14];
		int i,x=0;
		for(i=0;i<n;i++) {
			String str=scan.next();
			if(str.equals("S")) {
				x=0;
			}
			else if(str.equals("H")) {
				x=1;
			}
			else if(str.equals("C")) {
				x=2;
			}
			else if(str.equals("D")) {
				x=3;
			}
			int y=scan.nextInt();
			abc[x][y]=1;
		}
		for(x=0;x<4;x++) {
			for(int y=1;y<14;y++) {
				if(abc[x][y] != 1) {
					if(x==0) {
						System.out.println("S "+y);
					}
					else if(x==1) {
						System.out.println("H "+y);
					}
					else if(x==2) {
						System.out.println("C "+y);
					}
					else if(x==3) {
						System.out.println("D "+y);
					}
				}
				
			}
		}
		scan.close();
}
}
