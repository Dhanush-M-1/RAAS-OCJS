import java.util.Scanner;
import java.util.TreeMap;

public class ChipPlay {
	
	/*
	 * This class represents each cell on the grid and keeps a link
	 * to its neighboring cells
	 */
	private static final class Chip {
		private int r, c;
		private char dir;
		private Chip left, right, up, down;
		
		private Chip(int r, int c,char dir){
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
		public String toString(){
			StringBuilder builder = new StringBuilder();
			
			builder.append(String.format("C(%d, %d):", r, c));
			if(left != null){
				builder.append(String.format(" L->C(%d, %d)", left.r, left.c));
			}
			if(right != null){
				builder.append(String.format(" R->C(%d, %d)", right.r, right.c));
			}
			if(up != null){
				builder.append(String.format(" U->C(%d, %d)", up.r, up.c));
			}
			if(down != null){
				builder.append(String.format(" D->C(%d, %d)", down.r, down.c));
			}
			return builder.toString();
		}
	}
	
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		char[][] grid = new char[n][m];
				
		for(int i = 0; i < n; i++){
			grid[i] = sc.next().toCharArray();
			sc.nextLine();
		}
		
		// Map to store the length of the path and corresponding occurences
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		// Try to find the path for each and every cell
		for(int a = 0; a < n; a++){
			for(int b = 0; b < m; b++){
				if(grid[a][b] != '.'){
					
					// create a net datastructure comprising of cells who keeps a link to their
					// neighboring cells also
					Chip[][] net = new Chip[n][m];
					for(int i = 0; i < n; i++){
						for(int j = 0; j < m; j++){
							if(grid[i][j] != '.'){
								if(net[i][j] == null) {
									net[i][j] = new Chip(i, j, grid[i][j]);
								}
								// consider this cell and move right
								int x = j + 1;
								while(x < m && grid[i][x] == '.') x++;
								if(x < m){
									if(net[i][x] == null) {
										net[i][x] = new Chip(i, x, grid[i][x]);
									}
									// create the right link and vice versa
									net[i][j].right = net[i][x];
									net[i][x].left = net[i][j];
								}
								
								// consider this cell and move down
								int y = i + 1;
								while(y < n && grid[y][j] == '.') y++;
								if(y < n){
									if(net[y][j] == null) {
										net[y][j] = new Chip(y, j, grid[y][j]);
									}
									// create the downward link and vice versa
									net[i][j].down = net[y][j];
									net[y][j].up = net[i][j];
								}
							}
						}
					}
					// Finished creating the net, now traverse the net for a given cell Chip(a, b) and solve
					int pathlength = 0;					
					Chip cur = net[a][b];
					while(cur != null){
						pathlength++;
						// destroy chip
						net[cur.r][cur.c] = null;
						
						if(cur.up != null){
							cur.up.down = cur.down;
						}
						if(cur.down != null){
							cur.down.up = cur.up;
						}
						if(cur.left != null){
							cur.left.right = cur.right;
						}
						if(cur.right != null){
							cur.right.left = cur.left;
						}						
						if(cur.dir == 'U'){
							cur = cur.up;							
							continue;
						}						
						if(cur.dir == 'D'){
							cur = cur.down;
							continue;
						}
						if(cur.dir == 'L'){
							cur = cur.left;
							continue;
						}
						if(cur.dir == 'R'){
							cur = cur.right;
							continue;
						}
					}
					Integer z = map.get(Integer.valueOf(pathlength));
					if(z == null){
						map.put(Integer.valueOf(pathlength), 1);
					}else{
						map.put(Integer.valueOf(pathlength), z + 1);
					}
				}
			}
		}
		System.out.println(map.lastEntry().getKey() + " " + map.lastEntry().getValue());
	}
}
