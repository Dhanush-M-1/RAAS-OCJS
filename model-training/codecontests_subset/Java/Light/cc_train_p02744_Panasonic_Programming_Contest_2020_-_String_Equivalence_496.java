import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		int cnt = 0;
		List<String> a = new ArrayList<String>();
		a.add("a");
		map.put(1, a);
		for(int i = 2; i <= n; i++){
			List<String> prevSet = map.get(i-1);
			List<String> newSet = new ArrayList<String>();
			for(String tmp : prevSet){// これまでのStringから一つとる
				char[] cArr = tmp.toCharArray();
				Set<Character> cSet = new HashSet<Character>();
				for(char c : cArr){//そのストリングに使われている文字種類数分のSet
					cSet.add(c);
				}
				for(int j = 0; j < cSet.size()+1; j++){
					newSet.add(tmp+alphabet[j]);
				}

			}
			map.remove(i-1);
			map.put(i,newSet);
		}
		for(String r : map.get(n)){
			System.out.println(r);
		}
		map.clear();
		scanner.close();

	}

}
