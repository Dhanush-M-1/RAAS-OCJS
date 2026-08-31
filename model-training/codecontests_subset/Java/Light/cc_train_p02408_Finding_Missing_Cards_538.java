import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean[][] found = new boolean[4][13];
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		while(n-- > 0){
			String mark = sc.next();
			int markNum = 0;
			if(mark.equals("S")) markNum = 0;
			else if(mark.equals("H")) markNum = 1;
			else if(mark.equals("C")) markNum = 2;
			else if(mark.equals("D")) markNum = 3;
			int num = sc.nextInt();
			found[markNum][num-1] = true;
		}
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				if(!found[i][j]){
					if(i == 0) System.out.print("S");
					else if(i == 1) System.out.print("H");
					else if(i == 2) System.out.print("C");
					else if(i == 3) System.out.print("D");
					System.out.println(" " + (j+1));
				}
			}
		}
	}

}