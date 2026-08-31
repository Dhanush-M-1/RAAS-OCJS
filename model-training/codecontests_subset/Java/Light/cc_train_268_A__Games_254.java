import java.util.*;
public class Games{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//int[] home = new int[n];
		//int[] guest = new int[n];
		Integer home = 0;
		Integer guest = 0;
		Integer result = 0;
		Map<Integer, Integer> homeMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> guestMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++){
			home = scan.nextInt();
			guest = scan.nextInt();
			if(homeMap.containsKey(home)){
				homeMap.put(home, homeMap.get(home)+1);
			}
			else{
				homeMap.put(home, 1);
			}
			if(guestMap.containsKey(guest)){
				guestMap.put(guest, guestMap.get(guest)+1);
			}
			else{
				guestMap.put(guest, 1);
			}
		}
		Integer[] keys = new Integer[n];
		keys = homeMap.keySet().toArray(keys);
		for(Integer key : keys){
			if(guestMap.containsKey(key)){
				result += (int)homeMap.get(key) * (int)guestMap.get(key);
			}
		}
		System.out.println(result);
	}
}