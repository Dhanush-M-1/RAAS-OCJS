import java.util.Scanner;

public class CFProblemD {
	static int c1;
	static int c2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int a = input.nextInt();
		c2 = a;
		int b = input.nextInt();
		c1 = b;
		int q = input.nextInt();
		SegmentTree tree = new SegmentTree(1, n);
		for (int q1 = 0; q1 < q; q1++) {
			int temp = input.nextInt();
			if (temp == 1) {
				int i1 = input.nextInt();
				int i2 = input.nextInt();
				tree.insert(i1, i2);
//				System.out.println(tree);
			} else {
				int p1 = input.nextInt();
				int out = 0;
				if (1 <= p1 - 1){
					out += tree.rangeQuery1(1, p1 - 1);
//					System.out.println("Checking" +   1 + " " + (p1-1));
				}
					
				if (p1 + k <= n){
					out += tree.rangeQuery2(p1 + k, n);
//					System.out.println("Checking" +   (p1 + k) + " " + n);
				}
				System.out.println(out);
			}
		}
	}

	public static class SegmentTree {
		int left;
		int right;
		int value1;
		int value2;
		int val;
		SegmentTree leftTree;
		SegmentTree rightTree;

		public SegmentTree(int _left, int _right) {
			left = _left;
			right = _right;
			value1 = 0;
			value2 = 0;
			val = 0;
			if (_left != _right) {
				leftTree = new SegmentTree(_left, _left + (_right - _left) / 2);
				rightTree = new SegmentTree(_left + (_right - _left) / 2 + 1,
						_right);
			}
		}

		public void insert(int loc, int quant) {
			if (left <= loc && right >= loc) {
				if (left != right) {
					leftTree.insert(loc, quant);
					rightTree.insert(loc, quant);
					this.calc();
				} else {
					val += quant;
					value1 += quant;
					value2 += quant;
					value1 = Math.min(c1, value1);
					value2 = Math.min(c2, value2);
				}
			}
		}

		private void calc() {
			value1 = leftTree.value1 + rightTree.value1;
			value2 = leftTree.value2 + rightTree.value2;
			val = leftTree.val + rightTree.val;
		}

		public int rangeQuery1(int _left, int _right) {
			if (_left <= left && _right >= right) {
				return value1;
			}
			if (_left > right || _right < left) {
				return 0;
			}
			return leftTree.rangeQuery1(_left, _right)
					+ rightTree.rangeQuery1(_left, _right);

		}

		public int rangeQuery2(int _left, int _right) {
			if (_left <= left && _right >= right) {
				return value2;
			}
			if (_left > right || _right < left) {
				return 0;
			}
			return leftTree.rangeQuery2(_left, _right)
					+ rightTree.rangeQuery2(_left, _right);

		}
		public String toString(){
			if(left != right){
				return "(" + left + ", " + right + ")" + val +  " " + value1 + " "  + value2 + "\n"  + leftTree  + rightTree;
			}
			return "(" + left + ", " + right + ")" + val +  " " + value1 + " "  + value2 + "\n";
		}

	}
}
