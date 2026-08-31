import java.util.*;
public class Main{
  public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder str=new StringBuilder(sc.next());
		String s=str.toString();
		if(str.toString().equals("keyence")) {
			System.out.println("YES");
			return;
		}
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<str.length()-i;j++) {
				if(str.delete(i,i+j+1).toString().equals("keyence")) {
					System.out.println("YES");
					return;
				}
				str=new StringBuilder(s);
			}
		}
		System.out.println("NO");

	}
}