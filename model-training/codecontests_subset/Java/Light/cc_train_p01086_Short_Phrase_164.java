import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main{
	static final Scanner s=new Scanner(System.in);
	static int getInt(){
		return Integer.parseInt(s.next());
	}
	static IntStream REPS(int l) {
		return IntStream.range(0,l);
	}
	static List<Integer>hoge=Arrays.asList(5,12,17,24,31);
	public static void main(String[]__){
		ArrayDeque<Integer>d=new ArrayDeque<>();
		
		cases:
		while(true){
			int n=getInt();
			if(n==0)return;
			int[]in=REPS(n).map(i->s.next().length()).toArray();
			int[]psum=new int[n+1];
			for(int i=0;i<n;i++)psum[i+1]=in[i];
			Arrays.parallelPrefix(psum,Integer::sum);
			for(int i=1;i<=n;i++) {
				d.clear();
				d.addAll(hoge);
				
				int v=psum[i-1];
				IntStream.rangeClosed(i,n).map(w->psum[w]-v).forEach(w->{
					if(!d.isEmpty()&&d.peekFirst()==w)
						d.pollFirst();
				});
				if(d.isEmpty()) {
					System.out.println(i);
					continue cases;
				}
			}
		}
	}
}