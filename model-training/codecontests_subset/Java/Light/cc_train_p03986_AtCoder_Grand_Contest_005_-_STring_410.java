import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Character> que = new ArrayDeque<>(200_000);	
		int s = 0;
		while((s = bf.read()) != -1) {
			if (s == 83) {//s
				que.push('S');
			} else if (s == 84) {//t
				if (que.size() > 0 && que.getFirst() == 'S') {
					que.pop();
				} else {
					que.push('T');
				}
			} else {
				break;
			}
		}
		
		System.out.println(que.size());
	}
}