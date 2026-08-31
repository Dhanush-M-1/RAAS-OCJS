import java.util.*;

public class Main {
	public static boolean is_prime(int x){
		switch(x){
		case 2 : return true;
		case 3 : return true;
		default:
			for(int e = 2 ; e <= Math.sqrt(x) ; e++){
				if(x % e ==0) return false;
			}
		return true;
		
		}
	}
	public static void main(String[] args) {
		int c = 0;
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		boolean[] tof = new boolean[100000000];
		Arrays.fill(tof, false);
		for(int i = 1 ; i <= N ; i++){
			int k = scn.nextInt();
			if(tof[k-1] == false){
				tof[k-1] = is_prime(k);
			}
		}
		for(int j = 0 ; j < 100000000 ; j++){
			if(tof[j] == true) c++;
		}
		System.out.println(c);
	}

}