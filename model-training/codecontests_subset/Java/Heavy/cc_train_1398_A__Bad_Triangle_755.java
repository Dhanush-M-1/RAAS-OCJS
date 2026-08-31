import java.util.*;

/** 
__                  __
( _)                ( _)
/ / \\              / /\_\_
/ /   \\            / / | \ \
/ /     \\          / /  |\ \ \
/  /   ,  \ ,       / /   /|  \ \
/  /    |\_ /|      / /   / \   \_\
/  /  |\/ _ '_| \   / /   /   \    \\
|  /   |/  0 \0\    / |    |    \    \\
|    |\|      \_\_ /  /    |     \    \\
|  | |/    \.\ o\o)  /      \     |    \\
\    |     /\\`v-v  /        |    |     \\
| \/    /_| \\_|  /         |    | \    \\
| |    /__/_ `-` /   _____  |    |  \    \\
\|    [__]  \_/  |_________  \   |   \    ()
/    [___] (    \         \  |\ |   |   //
|    [___]                  |\| \|   /  |/
/|    [____]                  \  |/\ / / ||
(  \   [____ /     ) _\      \  \    \| | ||
\  \  [_____|    / /     __/    \   / / //
|   \ [_____/   / /        \    |   \/ //
|   /  '----|   /=\____   _/    |   / //
__ /  /        |  /   ___/  _/\    \  | ||
(/-(/-\)       /   \  (/\/\)/  |    /  | /
(/\/\)           /   /   //
_________/   /    /
\____________/    (



*/

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- >0) {
			
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			solver(n,arr);
		}
	}
	public static void solver(int n,int[] arr) {
		for(int i=0;i<n-2;i++) {
			if(arr[i]+arr[i+1]<=arr[n-1]) {
				System.out.println((i+1)+" "+(i+2)+" "+n);
				return;
			}
		}
		System.out.println(-1);
	}
	
}
