//import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.StringTokenizer;

public class start {
	
	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println((int)'a'+" "+(int)'A');
		Scanner sc = new Scanner(System.in);
		int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
		int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
		char[][] grid = new char[4][];
		for(int i = 0; i < 4; ++i)
			grid[i] = sc.next().toCharArray();
		
		boolean eh=false;
	outer:for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				for(int dirc=0;dirc<8;dirc++){
				   int xs=0; int dots=0;
				   for(int u=0;u<3;u++){
					   int x=i+u*dx[dirc];
					   int y=j+u*dy[dirc];
					   if(valid(x,y)){
                           if(grid[x][y]=='x')
                        	   xs++;
                           if(grid[x][y]=='.')
                        	   dots++;
					   }
				   }
				   if(xs+dots==3&&dots==1){
					   eh=true;
					   break outer;
				   }
				   
				}
				
			}
		}
		if(eh){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		
	}
	static boolean valid(int x, int y) { return x >= 0 && y >= 0 && x < 4 && y < 4; }

}