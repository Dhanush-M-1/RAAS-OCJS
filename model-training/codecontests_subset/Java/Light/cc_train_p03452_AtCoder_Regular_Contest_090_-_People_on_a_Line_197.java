import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.StringTokenizer;
class Main{
	public static void main(String[] args) {
		SC sc=new SC(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		WUnionFindTree uft=new WUnionFindTree(N);
		for(int i=0; i<M; i++) {
			int L=sc.nextInt()-1;
			int R=sc.nextInt()-1;	//0 origin
			int D=sc.nextInt();
			if(uft.same(L,R)) {	//同じグループなら矛盾していないかを確認
				if(uft.diff(L,R)!=D) {
					pl("No");
					System.exit(0);
				}
				else {
					//
				}
			}
			else {	//同じグループでないならマージする。
				uft.union(L,R,D);
				if(uft.diff(L,R)!=D) {
					pl("No");
					System.exit(0);
				}
			}
		}
		pl("Yes");
	}
	static class SC {
		private BufferedReader reader = null;
		private StringTokenizer tokenizer = null;
		public SC(InputStream in) {
			reader = new BufferedReader(new InputStreamReader(in));
		}
		public String next() {
			if (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new UncheckedIOException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
	public static void pl(Object o) {
		System.out.println(o);
	}
	public static void pl() {
		System.out.println();
	}
	public static void p(Object o) {
		System.out.print(o);
	}
	public static class WUnionFindTree{
		int[] par; // 親の番号
		int[] ws;  // 親との重みの差
		public WUnionFindTree(int n){
			par = new int[n+1];
			ws  = new int[n+1];
			for(int i = 0; i <= n; i++){ par[i] = -1; }
		}
		public int find(int x){
			if(par[x] < 0){
				return x;
			}else{
				final int parent = find(par[x]);
				ws[x] += ws[par[x]];
				return par[x] = parent;
			}
		}
		public int weight(int x){
			find(x);
			return ws[x];
		}
		public boolean union(int x, int y, int w){ // x <-(w)- y (x + w = y)
			w += weight(x);
			w -= weight(y);
			x = find(x); y = find(y);
			if(x != y){
				if(par[y] < par[x]) {
					int tmp = x; x = y; y = tmp; w = -w;
				}
				par[x] += par[y]; par[y] = x;
				ws[y] = w;
				return true;
			}else{
				return false;
			}
		}
		public boolean same(int x, int y){
			return find(x) == find(y);
		}
		public Integer diff(int x, int y){ // y - x を求める. 比較不能ならnull.
			if(!same(x, y)){ return null; }
			return this.weight(y) - this.weight(x);
		}
		public int size(int x){
			return -par[find(x)];
		}
	}
}