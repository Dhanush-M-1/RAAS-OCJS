import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class CF249B {

	public static void main(String[] args){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int tmp, tmp2;
		for(int i=0 ; i < n ; ++i){
			tmp = sc.nextInt();
			if(map.containsKey(tmp))
				map.put(tmp, map.get(tmp) + 1);
			else
				map.put(tmp, 1);
		}
		--n;
		for(int i=0 ; i<n  ; ++i){
			tmp = sc.nextInt();
			tmp2 = map.get(tmp);
			if( tmp2 > 1)
				map.put(tmp, tmp2-1);
			else
				map.remove(tmp);
			if(map1.containsKey(tmp))
				map1.put(tmp, map1.get(tmp) + 1);
			else
				map1.put(tmp, 1);
		}
		--n;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey());
		}
		for(int i=0; i<n; ++i){
			tmp = sc.nextInt();
			tmp2 = map1.get(tmp);
			if( tmp2 > 1)
				map1.put(tmp, tmp2-1);
			else
				map1.remove(tmp);
		}
		for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
			System.out.println(entry.getKey());
		}
	}
}
