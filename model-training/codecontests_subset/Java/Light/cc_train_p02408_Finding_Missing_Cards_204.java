import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] a = new boolean[4][13];
		
		for(int im = 0; im < 4; im++) {
			for(int in = 0; in < 13; in++) {
				a[im][in] = true;
			}
		}
		
		for(int i = 0; i < n; i++){
			String mark = sc.next();
			int num = sc.nextInt() - 1;
			int mar;
			
			if(mark.equals("S")) {
				mar = 0;
			}else if(mark.equals("H")) {
				mar = 1;
			}else if(mark.equals("C")) {
				mar = 2;
			}else {
				mar = 3;
			}
			
			a[mar][num] = false;
		}
		
		for(int im = 0; im < 4; im++) {
			for(int in = 0; in < 13; in++) {
				if(a[im][in]) {
					if(im == 0) {
						System.out.print("S");
					}else if(im == 1) {
						System.out.print("H");
					}else if(im == 2) {
						System.out.print("C");
					}else {
						System.out.print("D");
					}
					
					System.out.println(" " + (in+1));
				}
			}
		}
		
	}
}

