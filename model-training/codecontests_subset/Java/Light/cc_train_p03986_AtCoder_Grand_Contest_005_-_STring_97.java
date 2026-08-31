import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		LinkedList list = new LinkedList();
		String x = sc.next();

		for(int i = 0;i < x.length();i++){
			if(x.charAt(i) == 'S'){
				list.add('S');
			}else{
				if(list.size() != 0 && (char)list.peekLast() == 'S'){
					list.pollLast();
				}else{
					list.add('T');
				}
			}
		}

		System.out.println(list.size());
	}
}
