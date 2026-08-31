import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] vx = {1,0,-1,0};
	static int[] vy = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int k = sc.nextInt();
		char[][] maze = new char[W][H];
		int walls = 0;
		for(int y=0;y<H;y++) {
			String s = sc.next();
			for(int x=0;x<W;x++) {
				maze[x][y] = s.charAt(x);
				if (maze[x][y] == '#') {
					walls++;
				}else{
					maze[x][y] = 'X';
				}
			}
		}
		int emptycells = H * W - walls - k;
		for(int x=0;x<W;x++) {
			for(int y=0;y<H;y++) {
				if(maze[x][y]=='X') {
					Queue<Pos> q = new ArrayDeque<Pos>();
					q.add(new Pos(x,y));
					while(!q.isEmpty() && emptycells>0) {
						Pos p = q.poll();
						if(maze[p.x][p.y]=='X') {
							maze[p.x][p.y]='.';
							emptycells--;
							for(int i=0;i<4;i++) {
								int nx = p.x + vx[i];
								int ny = p.y + vy[i];
								if(nx>=0 && nx<W && ny>=0 && ny<H) {
									if(maze[nx][ny]=='X') {
										q.add(new Pos(nx,ny));
									}
								}
							}
						}
					}
					break;
				}
			}
		}
		for(int y=0;y<H;y++) {
			for(int x=0;x<W;x++) {
				System.out.print(maze[x][y]);
			}
			System.out.println();
		}
	}

}
class Pos {
	int x = 0;
	int y = 0;
	public Pos (int x, int y) {
		this.x = x;
		this.y = y;
	}
}