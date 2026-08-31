import java.util.*;
import java.lang.Object;
public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int x[]=new int[4];
		String s = in.next();
		for(int i=0;i<s.length();i++){
		    if(s.charAt(i)=='+') continue;
		    x[s.charAt(i)-'0']++;
		}
		String res="";
		for(int i=0;i<x[1];i++){
		    res+="1+";
		}
		for(int i=0;i<x[2];i++){
            res+="2+";
		}
		for(int i=0;i<x[3];i++){
		    res+="3+";
		}
		res = res.substring(0,(x[1]+x[2]+x[3])*2-1);
		System.out.print(res);
		
	}
}