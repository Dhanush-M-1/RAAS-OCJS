import java.util.*;

class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int[][] isExist = new int[4][13];
		char ch;
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 13; j++)
				isExist[i][j] = 0;
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++){
			String mark = sc.next();
			int num = sc.nextInt();
			
			if(mark.equals("S"))
				isExist[0][num-1] = 1;
			else if(mark.equals("H"))
				isExist[1][num-1] = 1;
			else if(mark.equals("C"))
				isExist[2][num-1] = 1;
			else
				isExist[3][num-1] = 1;
		}
		
		for(int i = 0; i < 4; i++){
			if(i == 0)
				ch = 'S';
			else if(i == 1)
				ch = 'H';
			else if(i == 2)
				ch = 'C';
			else
				ch = 'D';
			
			for(int j = 0; j < 13; j++){
				if(isExist[i][j] == 0)
					System.out.println(ch + " " + (j + 1));
			}
		}
	}
}