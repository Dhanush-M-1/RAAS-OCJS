import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h,w;
		while(true) {
			h=scan.nextInt();
			w=scan.nextInt();
			if(h==0&&w==0)break;
			int icheck=1,j_check;
			for(int i=0;i<h;i++) {
				j_check=icheck;
				for(int j=0;j<w;j++) {
					if(j_check==0) {
						System.out.print(".");
						j_check=1;
					}else {
						System.out.print("#");
						j_check=0;
					}
				}
				if(icheck==1)icheck=0;
				else icheck=1;
				System.out.println();
			}
			System.out.println();
		}
		scan.close();
	}

}
