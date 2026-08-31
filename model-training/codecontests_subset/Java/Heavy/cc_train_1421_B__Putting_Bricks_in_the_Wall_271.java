import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for(int t = 0;t < tc;t++) {
			int n = s.nextInt();
			char[][] input = new char[n][n];
			for(int i = 0;i < n;i++) {	
				String str = s.next();
				for(int j = 0;j < n;j++) {
					input[i][j] = str.charAt(j);
				}
			}
			int ans = 0;
			if(input[0][1] == input[1][0]) { // 0 0 
				if(input[n - 1][n - 2] == input[n - 2][n - 1]) {
					if(input[0][1] != input[n - 1][n - 2]) {
						System.out.println("0");
					}
					else {
						System.out.println("2");
						System.out.println("1 2");
						System.out.println("2 1");
					}
				}
				else {
					if(input[0][1] == input[n - 1][n - 2]) {
						System.out.println("1");
						System.out.println((n) + " " + (n - 1));
					}
					else {
						System.out.println("1");
						System.out.println((n - 1) + " " + (n));
					}
				}
			}
			else {
				if(input[n - 1][n - 2] == input[n - 2][n - 1]) {
					if(input[0][1] == input[n - 1][n - 2]) {
						System.out.println("1");
						System.out.println("1 2");
					}
					else {
						System.out.println("1");
						System.out.println("2 1");
					}
				}
				else {
					System.out.println("2");
					if(input[0][1] == input[n - 1][n - 2]) {
						System.out.println("1 2");
						System.out.println((n - 1) + " " + (n));
					}
					else {
						System.out.println("2 1");
						System.out.println((n - 1) + " " + (n));
					}
				}
			}
			coordinate obj = new coordinate();
			coordinate obj1 = new coordinate();
			boolean[][] visited = new boolean[n][n];
//			int ans = ForZero(input , 0 , 0 , obj , obj1 , visited , '0');
//			visited = new boolean[n][n];
//			if(ans != 2)
//				ForZero(input , 0 , 0 , obj , obj1 , visited , '1');
		}
	}

	public static int ForZero(char[][] input , int x , int y , coordinate obj , coordinate obj1 , boolean[][] visited , char val) { 

		int n = input.length;
		int m = input[0].length;
		//System.out.println("B");
		if(x < 0 || x >= n || y < 0 || y >= m) {
			return -1;
		}
		if(visited[x][y]) return -1;
//		if(input[x][y] == val && input[x][y] != 'S' && input[x][y] != 'F') {
//			return -1;
//		}
		
		visited[x][y] = true;
		int temp = 0;
		char ch = (val == '0') ? '1' : '0';
		//System.out.println("R");
		if(x - 1 >= 0) {
			if(visited[x - 1][y] || input[x - 1][y] == 'S') return -1;
			if(input[x - 1][y] == ch) {
				temp++;
				obj.x = x - 1;
				obj.y = y;
			}
			//System.out.println("F");
		}
		if(x + 1 < n) {
			if(visited[x + 1][y] || input[x + 1][y] == 'S') return -1;
			if(input[x + 1][y] == ch) {
				temp++;
				if(obj.x != -1) {
					obj1.x = x + 1;
					obj1.y = y;
				}
				else {
					obj.x = x + 1;
					obj.y = y;
				}
			}
			//System.out.println("S");
		}
		
		if(y + 1 < n) {
			if(visited[x][y + 1] || input[x][y + 1] == 'S') return -1;
			if(input[x][y + 1] == ch) {
				temp++;
				if(obj.x == -1) {
					obj.x = x;
					obj.y = y + 1;
				}
				else if(obj1.x == -1){
					obj1.x = x;
					obj1.y = y + 1;
				}
			}
			//System.out.println("T");
		}
		if(y - 1 >= 0) {
			if(visited[x][y - 1] || input[x][y - 1] == 'S') return -1;
			if(input[x][y - 1] == ch) temp++;
			if(obj.x == -1) {
				obj.x = x;
				obj.y = y + 1;
			}
			else if(obj1.x == -1){
				obj1.x = x;
				obj1.y = y + 1;
			}
		}
		
		if(temp == 0) {
			System.out.println(temp);
			return -1;
		}
		if(temp <= 2) {
			if(temp != 0 && obj.x == -1) {
				System.out.println("0n");
				return -1;
			}
			if(obj.x != -1)
			System.out.println((obj.x + 1) +  " " + (obj.y + 1));
			if(obj1.x != -1) System.out.println((obj1.x + 1) + " " + (obj1.y + 1));
			return -1;
		}
		else {
			obj = new coordinate();
			obj1 = new coordinate();
		}

		boolean f = false , s = false , t = false , fo = false;
		//System.out.println("V");
		int op1 = ForZero(input , x + 1 , y , obj , obj1 , visited , val);
		if(op1 == -1) f = true;
		if(op1 == 2) return 2;
		int op2 = ForZero(input , x - 1 , y , obj , obj1 , visited , val);
		if(op2 == -1) s = true;
		if(op2 == 2) return 2;
		int op3 = ForZero(input , x , y + 1 , obj , obj1 , visited , val);
		if(op3 == -1) t = true;
		if(op3 == 2) return 2;
		int op4 = ForZero(input , x , y - 1 , obj , obj1 , visited , val);
		if(op4 == -1) fo = true;
		if(op4 == 2) return 2;
		int cnt = 0;
		if(f) {
			cnt++;
			if(x + 1 < n && y < n && input[x + 1][y] == val) {
		//		System.out.println("F");
				obj.x = x + 1;
				obj.y = y;
			}
		}
		if(s) {
			cnt++;
			if(x - 1 >= 0 && y < n && input[x - 1][y] == val) {
				//System.out.println("S");
				if(cnt == 0) {
					obj.x = x - 1;
					obj.y = y;
				}
				else {
					obj1.x = x - 1;
					obj1.y = y;
				}
			}

		}
		if(t) {
			cnt++;
			if(y + 1 < n && input[x][y + 1] == val) {
			//	System.out.println(input[x][y + 1] + " " + val);
				System.out.println(x + " " + (y + 1));
				if(cnt == 0) {
					obj.x = x;
					obj.y = y + 1;
				}
				else if(cnt == 1){
					obj1.x = x;
					obj1.y = y + 1;
				}
			}
		}
		if(fo) {
			cnt++;
			if(y - 1 >= 0 && input[x][y - 1] == val) {
				//System.out.println("FO");
				if(cnt == 0) {
					obj.x = x;
					obj.y = y - 1;
				}
				else if(cnt == 1){
					obj1.x = x;
					obj1.y = y - 1;
				}
			}
		}
	//	System.out.println(val + "L");
		if(cnt >= 2) {
			System.out.println(4 - cnt + "N");
			if(obj.x != -1)
				System.out.println((obj.x) + " " + (obj.y));
			if(obj1.x != -1) {
				System.out.println((obj1.x) + " " + (obj1.y));
			}
			return 2;
		}

		obj = new coordinate();
		obj1 = new coordinate();

		return 0;


	}


}

class coordinate {
	int x = -1;
	int y = -1;
}
