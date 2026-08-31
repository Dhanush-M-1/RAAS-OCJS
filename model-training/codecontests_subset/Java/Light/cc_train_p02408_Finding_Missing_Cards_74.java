import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) throws IOException {
		//File file = new File("input.txt");
		//Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);
		
		boolean[][] T = new boolean[4][13];
		for(int i = 0; i < 4; i++) T[i] = new boolean[13];
		String[] mm = {"S", "H", "C", "D"};
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++){
			String m = sc.next();
			int num = sc.nextInt();
			if(m.equals("S")) T[0][num-1] = true;
			if(m.equals("H")) T[1][num-1] = true;
			if(m.equals("C")) T[2][num-1] = true;
			if(m.equals("D")) T[3][num-1] = true;
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				if(!T[i][j]){
					System.out.println(mm[i] + " " + (j+1));
				}
			}
		}
	}
}
