import java.util.*;
public class A {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		int cnt=0, fin=0;
		while(sc.hasNextLine())
		{
			String str=sc.nextLine();
			if(str.charAt(0)=='+') ++cnt;
			else if(str.charAt(0)=='-') --cnt;
			else fin+=cnt*(str.length()-str.indexOf(':')-1);
		}
		System.out.println(fin);
		sc.close();
	}

}
