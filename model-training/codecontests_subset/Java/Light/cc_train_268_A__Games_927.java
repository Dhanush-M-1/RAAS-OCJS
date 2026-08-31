import java.util.*;

public class Games{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		int[] ab = new int[n];
		int[] ac = new int[n];
		for(int i =0; i < n; ++i){
			String[] a = s.nextLine().split(" ");
			ab[i] = Integer.parseInt(a[0]);
			ac[i] = Integer.parseInt(a[1]);
		}
		int counter=0;
		for(int j =0; j < ab.length; ++j){
			for(int v =0; v < ac.length; ++v){
				if (ab[j] == ac[v]){
				counter++;
				}
			}
		}
		System.out.println(counter);
	}
}