import java.util.*;
public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lengthOfString = sc.nextInt();
		String s = sc.next();
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String largestKey = "";
		
		for(int i = 1; i < lengthOfString; i++) {
			String currentTwoGram = s.charAt(i-1) + "" + s.charAt(i);
			if(map.containsKey(currentTwoGram)) {
				int newMapValue = map.get(currentTwoGram) + 1;
				map.put(currentTwoGram, newMapValue);
				if(largestKey == "") {
					largestKey = currentTwoGram;
				}else {
					if(map.get(largestKey) < newMapValue) {
						largestKey = currentTwoGram;
					}
				}
			}else {
				map.put(currentTwoGram, 1);
				if(largestKey == "") {
					largestKey = currentTwoGram;
				}else {
					if(map.get(largestKey) < 1) {
						largestKey = currentTwoGram;
					}
				}
			}
		}
		System.out.println(largestKey);
	}
}