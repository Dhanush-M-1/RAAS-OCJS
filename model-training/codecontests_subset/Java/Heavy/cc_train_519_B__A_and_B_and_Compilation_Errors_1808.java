import java.util.*;
import java.lang.*;
public class Codeforces{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), a = 0, b = 0;
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> h2 = new HashMap<Integer, Integer>();
		for(int i = 1; i <= n; i++){
			int x = sc.nextInt();
			if(h.containsKey(x)){
				h.put(x, h.get(x) + 1);
			}else{
				h.put(x, 1);
			}
		}
		for(int i = 1; i <= n - 1; i++){
			int x = sc.nextInt();
			if(h1.containsKey(x)){
                                h1.put(x, h1.get(x) + 1);
                        }else{
                                h1.put(x, 1);
                        }
		}
		for(int i = 1; i <= n - 2; i++){
                        int x = sc.nextInt();
                        if(h2.containsKey(x)){
                                h2.put(x, h2.get(x) + 1);
                        }else{
                                h2.put(x, 1);
                        }
                }
		for(Integer key : h.keySet()){
			if(!h1.containsKey(key) || (h.get(key) > h1.get(key))){
				System.out.println(key);
				break;
			}
		}
		for(Integer key : h1.keySet()){
                       if(!h2.containsKey(key) || (h1.get(key) > h2.get(key))){
                                System.out.println(key);
                                break;
                        }
                }
	}
}
