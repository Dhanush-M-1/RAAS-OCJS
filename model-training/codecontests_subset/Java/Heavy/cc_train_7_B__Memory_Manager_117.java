import java.io.*;
import java.util.*;

public class CF7B {
	static class Block {
		int i, n, x;
		Block(int i, int n, int x) {
			this.i = i;
			this.n = n;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Block> list = new LinkedList<>();
		list.add(new Block(1, m, 0));
		int id = 0;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("alloc")) {
				int n = Integer.parseInt(st.nextToken());
				int x = 0;
				ListIterator<Block> lit = list.listIterator();
				while (lit.hasNext()) {
					Block b = lit.next();
					if (b.x == 0 && b.n >= n) {
						int i = b.i;
						b.i += n;
						b.n -= n;
						if (b.n == 0)
							lit.remove();
						else
							lit.previous();
						x = ++id;
						lit.add(new Block(i, n, x));
						break;
					}
				}
				pw.println(x > 0 ? x : "NULL");
			} else if (s.equals("erase")) {
				int x = Integer.parseInt(st.nextToken());
				boolean found = false;
				ListIterator<Block> lit = list.listIterator();
				while (lit.hasNext()) {
					Block b = lit.next();
					if (b.x == x && x != 0) {
						found = true;
						b.x = 0;
						if (lit.hasNext()) {
							Block bn = lit.next();
							if (bn.x == 0) {
								b.n += bn.n;
								lit.remove();
							} else
								lit.previous();
						}
						lit.previous();
						if (lit.hasPrevious()) {
							Block bp = lit.previous();
							if (bp.x == 0) {
								b.i = bp.i;
								b.n += bp.n;
								lit.remove();
							}
						}
						break;
					}
				}
				if (!found)
					pw.println("ILLEGAL_ERASE_ARGUMENT");
			} else {
				ListIterator<Block> lit = list.listIterator();
				int i = 1;
				while (lit.hasNext()) {
					Block b = lit.next();
					if (b.x == 0)
						lit.remove();
					else {
						b.i = i;
						i += b.n;
					}
				}
				if (i <= m)
					lit.add(new Block(i, m - i + 1, 0));
			}
		}
		pw.close();
	}
}
