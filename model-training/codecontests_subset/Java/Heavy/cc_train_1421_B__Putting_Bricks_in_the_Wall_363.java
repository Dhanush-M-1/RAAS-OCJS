import java.util.*;

public class Putting {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		while(t>0) {
			
			int n = scanner.nextInt();
			
			char [][] grid = new char [n+1][n+1];
			
			String s;
			int k = 0;
			
			for(int i = 1; i <= n; i++) {	
				s = scanner.next();			
				for(int j = 1; j <= n; j++) {
					grid[i][j] = s.charAt(k);
					k++;
				}
				k = 0;		
			}
			
			solve(grid, n);
			
			t--;		
		}
		scanner.close();
	}
	
	public static void solve(char[][] grid, int n) {
		
		int c = 0;
		
		String s1 = "";
		String s2 = "";
		
		char a = grid[1][2];
		char b = grid[2][1];
		char d = grid[n-1][n];
		char e = grid[n][n-1];
		
		if(a == b) {
			if (a == '0') {
				if(d != '1') {
					d = '1'; 
					c++;
					s1 += (n-1) + " " + n; 
				}
				if(e != '1') {
					e = '1';
					c++;
					s2 += n + " " + (n-1);
				}			
			}else {				
				if(d != '0') {
					d = '0'; 
					c++;
					s1 += (n-1) + " " + n; 
				}
				if(e != '0') {
					e = '0';
					c++;
					s2 += n + " " + (n-1);					
				}		
			}
		}else {
			if(a == d && d == '1') { // b= 0
				a = b;
				c++;
				s1 += 1 + " " + 2;
				
				if (e != d) {
					e = d;
					c++;
					s2 += n + " " + (n-1);	
				}	
			}else if(a == d && d == '0') { // b =1
				a = b;
				c++;
				s1 += 1 + " " + 2;
				
				if(e != d) {
					e = d;
					c++;
					s2 += n + " " + (n-1);	
				}		
			}else if(a == e && e == '1') { // b = 0
				a = b;
				c++;
				s1 += 1 + " " + 2;
				
				if(e != d) {
					d = e;
					c++;
					s2 += (n-1) + " " + n;
				}					
			}else if(a == e && e == '0') { // b = 1
				a = b;
				c++;
				s1 += 1 + " " + 2;
				
				if(e != d) {
					d = e;
					c++;
					s2 += (n-1) + " " + n;
				}
				
			}else if(b == e && e == '0') { // a = 1
				b = a;
				c++;
				s1 += 2 + " " + 1;
				
				if(e != d) {
					d = e;
					c++;
					s2 += (n-1) + " " + n;
				}
			
			}else if(b == e && e == '1') { // a = 0
				b = a;
				c++;
				s1 += 2 + " " + 1;
				
				if(e != d) {
					d = e;
					c++;
					s2 += (n-1) + " " + n;
				}				
			}						
		}		
		System.out.println(c);
		if(s1 != null) System.out.println(s1);
		if(s2 != null) System.out.println(s2);
		System.out.println();		
	}
}
