import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){

		solve_abcPpc_d();
	}
  
  	public static void solve_abcPpc_d(){

		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		
		solve_abcPpc_d_dfs("",N,'a');
		
		sc.close();
	}

	public static void solve_abcPpc_d_dfs(String s, int N, char mx){
		
		
		//if length == N
		if(s.length() == N){
			//print string
			System.out.println(s);
		}
		else{
			//for c = a , c <= mx, c++
			for(char c = 'a';c <= mx; c++){
				
				solve_abcPpc_d_dfs(s + c, N, (c == mx ? (char)(mx + 1): mx));
			}
		
		}
	}
}