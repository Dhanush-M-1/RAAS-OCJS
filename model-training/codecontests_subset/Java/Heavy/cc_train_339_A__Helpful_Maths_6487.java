import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Advancer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);
		//int n=in.nextInt();
		String str=in.next();
		List<Integer> l=new ArrayList<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch!='+')
				l.add(Integer.parseInt(String.valueOf(ch)));
		}
		Collections.sort(l);
		String res="";
		for(int i=0;i<l.size();i++) {
			res+=l.get(i)+"+";
		}
		System.out.println(res.substring(0,res.length()-1));
		
	}

}
