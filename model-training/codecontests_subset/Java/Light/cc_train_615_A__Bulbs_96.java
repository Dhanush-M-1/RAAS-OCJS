import java.util.*;
public class code{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		boolean[] l = new boolean[n];
		for(int i = 0; i<m; i++){
			int k = in.nextInt();
			for(int j = 0; j <k ; j++){
				int y = in.nextInt();
				l[y-1] = true;
			}
		}
		System.out.println(c(l));
		
	}
	static String c(boolean[] l){
		for(boolean i: l){
			if(!i){
				return "NO";
			}
		}
		return "YES";
	}
}