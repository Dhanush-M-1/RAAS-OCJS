import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main{

	private void solve(){
		int n=gInt();
		int[][]open=REPS(n).mapToObj(i->ints(10).toArray()).toArray(int[][]::new);
		int[][]v   =REPS(n).mapToObj(i->ints(11).toArray()).toArray(int[][]::new);

		Merger<Integer>max=new Merger<>(Integer.MIN_VALUE,Math::max);

		for(int b:rep(1,0b1111111111)) {
			boolean f=false;
			int sum=0;
			for(int i:rep(n)) {
				int c=(int)REPS(10)
						.filter(j->((1<<j)&b)>0&&open[i][j]==1)
						.count();
				f|=c!=0;
				sum+=v[i][c];
			}
			if(f)
				max.update(sum);
		}
		System.out.println(max.get());
	}

	public static class Merger<T>{
		private T v;
		private BinaryOperator<T>f;
		public Merger(T init,BinaryOperator<T>merge){
			v=init;
			f=merge;
		}
		public T update(T t) {
			return v=f.apply(v,t);
		}
		public T get() {
			return v;
		}
	}

	public static void main(String[]$){
		new Main().solve();
	}

	static Scanner s=new Scanner(System.in);


	static int gInt(){
		return s.nextInt();
	}

	static long gLong(){
		return s.nextLong();
	}

	static long gDouble(){
		return s.nextLong();
	}


	static Range rep(int i){
		return new Range(i);
	}
	static Range rep(int f,int t,int d){
		return new Range(f,t,d);
	}
	static Range rep(int f,int t){
		return rep(f,t,1);
	}
	static Range rrep(int f,int t){
		return rep(f,t,-1);
	}

	static class Range implements Iterable<Integer>,PrimitiveIterator.OfInt{

		int to,cur,d;

		Range(int from,int to,int d){
			this.cur=from-d;
			this.to=to;
			this.d=d;
		}

		Range(int n){
			this(0,n-1,1);
		}

		@Override
		public Iterator<Integer> iterator(){
			return this;
		}

		@Override
		public boolean hasNext(){
			return cur+d==to||(cur!=to&&(cur<to==cur+d<to));
		}

		@Override
		public int nextInt(){
			return cur+=d;
		}
	}


	static IntStream REPS(int v){
		return IntStream.range(0,v);
	}

	static IntStream REPS(int l,int r){
		return IntStream.rangeClosed(l,r);
	}


	static IntStream ints(int n){
		return REPS(n).map(i->gInt());
	}

	static Stream<String> strs(int n){
		return REPS(n).mapToObj(i->s.next());
	}

}