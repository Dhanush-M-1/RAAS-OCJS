import java.util.Scanner;

public class WoodCutters {
	
	static class Pair {
		int x, h;
		
		Pair(int x, int h) {
			this.x=x;
			this.h=h;
		}
		
	}

	public static void main(String[] args) {
		
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		
		Pair[] trees = new Pair[n+1];
 		
		for(int i=0; i<n; i++) {
			int x = scanner.nextInt();
			int h = scanner.nextInt();
			trees[i] = new Pair(x, h);
		}
		
		trees[n] = new Pair(trees[n-1].x + trees[n-1].h + 1, 0);
		
		int res = 0;
		int leftBound = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			if(trees[i].x - trees[i].h > leftBound) {
				res++;
				leftBound = trees[i].x;
			} else if(trees[i].x + trees[i].h < trees[i+1].x) {
				res++;
				leftBound = trees[i].x + trees[i].h;
			} else {
				leftBound = trees[i].x;
			}
		}
		
		System.out.println(res);

	}

}