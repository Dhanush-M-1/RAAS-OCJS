import java.util.*;
import java.io.*;

public class P1 {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static char[] pal;
	static HashMap<Character, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		N = sc.nextInt();
		sc.nextLine();
		pal = sc.nextLine().toCharArray();
		for (int i = 0; i < pal.length; i++) {
			int val = 0;
			if(map.containsKey(pal[i])){
				val = map.get(pal[i]);
			}
			map.put(pal[i], val+1);
		}
		boolean pos = true;
		String res = "";
		for(Character c : map.keySet()){
			int val = map.get(c);
			if(N > val || val % N != 0){
				pos = false;
				break;
			}
			else {
				int rep = val / N;
				for (int i = 0; i < rep; i++) {
					res+=c;
				}
			}
		}
		
		if(pos){
			String fin = "";
			for (int i = 0; i < N; i++) {
				fin += res;
			}
			System.out.println(fin);
		}
		else{
			System.out.println(-1);
		}
	}
}
