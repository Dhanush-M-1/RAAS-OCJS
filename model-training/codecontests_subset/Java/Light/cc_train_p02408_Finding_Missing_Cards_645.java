import java.util.*;
 class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean[][] crd = new boolean[4][13];

		for(int i=0; i<n; i++){	
			String s = sc.next();
			int a = sc.nextInt() - 1;
			if (s.equals("S")) {
				crd[0][a] = true;
			}
			else if (s.equals("H")) {
				crd[1][a] = true;
			}
			else if (s.equals("C")) {
				crd[2][a] = true;
			}
			else if (s.equals("D")) {
				crd[3][a] = true;
			}
		}

		for(int w=0;w<4;w++){
			for(int j=0; j<13;j++){
				if(crd[w][j] == false){
					if(w==0){
						System.out.println("S" + " " + (j+1));
					} else if(w==1){
						System.out.println("H" + " " + (j+1));
					} else if(w==2){
						System.out.println("C" + " " + (j+1));
					} else {
						System.out.println("D" + " " + (j+1));
					}
				}
			}
		}

	}
}
