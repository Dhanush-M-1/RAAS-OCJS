import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] ps = new int[n];
		
		for(int i=0; i<ps.length; i++) {
			ps[i] = sc.nextInt();
		}
		sc.close();
		
		int count =0;
		
		for(int i=0; i<ps.length; i++){
			if(ps[i] == i+1) {
				swap(ps,i);
				count += 1;
			}
		}
		
		System.out.println(count);

	}
	
	public static void swap(int[] ps, int i) {
		if(i != ps.length-1) {
			int a = ps[i];
			ps[i] = ps[i+1];
			ps[i+1] = a;
		}
	}

}
