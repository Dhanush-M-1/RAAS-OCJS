import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		List<S> slist = new ArrayList<>();
		List<C> clist = new ArrayList<>();
		for(int i = 0; i < n; i++){
			slist.add(new S(scanner.nextInt(),scanner.nextInt()));
		}
		for(int i = 0; i < m; i++){
			clist.add(new C(scanner.nextInt(), scanner.nextInt()));
		}

		for(int i = 0; i< n; i++){
			int x = slist.get(i).x;
			int y = slist.get(i).y;
			int len = Integer.MAX_VALUE;
			int count = 0;
			for(int j = 0; j < m; j++){
				int cx = clist.get(j).x;
				int cy = clist.get(j).y;
				if(Math.abs(x-cx) + Math.abs(y-cy) < len){
					len = Math.abs(x-cx) + Math.abs(y-cy);
					count = j;
				}
			}
			System.out.println(count+1);
		}
	}
}

class S{
	int x;
	int y;
	public S(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class C{
	int x;
	int y;
	public C(int x, int y){
		this.x=x;
		this.y=y;
	}
}