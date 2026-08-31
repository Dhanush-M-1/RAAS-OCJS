import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fences {

	public static class Interval implements Comparable<Interval> {

		public int left, right;

		public Interval(int l, int r) {
			this.left = l;
			this.right = r;
		}

		public boolean intersect(Interval other) {
			Interval ml, mr;
			if (this.left == other.left) {
				return true;
			}
			if (this.left < other.left) {
				ml = this;
				mr = other;
			} else {
				ml = other;
				mr = this;
			}
			return (ml.right >= mr.left);
		}

		@Override
		public int compareTo(Interval other) {
			return this.left - other.left;
		}

		public boolean equals(Object value) {
			Interval other = (Interval) value;
			return this.intersect(other);
		}

	}
	
	public static class Tree implements Comparable<Tree> {
		
		public int x, height;

		public Tree(int x, int height) {			
			this.x = x;
			this.height = height;
		}

		@Override
		public int compareTo(Tree other) {
			return x - other.x;
		}
		
		public Interval cutLeft() {
			return new Interval(this.x - this.height, this.x);
		}
		
		public Interval cutRight() {
			return new Interval(this.x, this.x + this.height);
		}		
		
	}

	public static int maxNumberOfCuts(Tree[] trees) {

		Arrays.sort(trees);
		
		int nFallenTrees = 1;
	
		Interval prevPoint = new Interval(trees[0].x, trees[0].x);
		
		for (int i = 1; i < trees.length - 1; ++ i) {
		
			Interval currentPoint = new Interval(trees[i].x, trees[i].x);
			Interval nextPoint = new Interval(trees[i + 1].x, trees[i + 1].x);									
			
			// Cut the tree and fall to left
			Interval iLeft = trees[i].cutLeft();					
			if (!prevPoint.intersect(iLeft)) {
				nFallenTrees += 1;
				prevPoint = iLeft; 
				continue;
			}
			
			// Cut the tree and fall to right
			Interval iRight = trees[i].cutRight();			
			if (!nextPoint.intersect(iRight)) {
				nFallenTrees += 1;
				prevPoint = iRight;
				continue;
			}			
			
			prevPoint = currentPoint;

		}
		
		if (trees.length > 1) {
			nFallenTrees += 1;	
		}				
		
		return nFallenTrees;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		Tree[] trees = new Tree[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			trees[i] = new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));			
		}
		
		System.out.println(maxNumberOfCuts(trees));
		
	}

}
