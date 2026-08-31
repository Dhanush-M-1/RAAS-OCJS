import java.util.*;
 
public class M_Round_6 {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
// B. Two-gram
		int n = sc.nextInt();
		String s = sc.next();
		ArrayList<String> a = new ArrayList<>();
		
		for(int i=0; i<n-1; i++) {
			String demo = s.substring(i, i+2);
			a.add(demo);
		}
		HashMap<String, Integer> h = new HashMap<>();	
		for(int i=0; i<a.size(); i++) {
			if( !h.containsKey(a.get(i))) h.put(a.get(i), 1);
			else {
				int v = h.get(a.get(i));
				h.put(a.get(i), v+1);
			}
		}
		int max=0; String ans="";
		for(String ch : h.keySet()) {
			if(max<h.get(ch)) {
				max=h.get(ch); ans=ch;  
			}
		}
		System.out.println(ans);
		
	}
}