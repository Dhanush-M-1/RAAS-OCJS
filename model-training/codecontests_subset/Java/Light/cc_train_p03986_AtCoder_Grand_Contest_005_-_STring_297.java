import java.util.Scanner;
import java.util.ArrayDeque;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayDeque<String> q = new ArrayDeque<String>();

		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)=='T' && "S".equals(q.peekLast())){
				String tmp = q.pollLast();
			}else{
				q.offer(str.charAt(i)+"");
			}
		}

		System.out.println(q.size());
	}
}