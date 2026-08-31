import java.util.*;
public class a{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		String s=in.next();

		int c,max=Integer.MIN_VALUE;
		String ans=null;

		for(int i=0;i<s.length()-1;i++){
			String sub=s.substring(i,i+2);
			c=count(s,sub);
			if(max<c){
				max=c;
				ans=sub;
			}
		}
		System.out.println(ans);
	}

	static int count(String text,String pattern){
		int c=0;

		for(int i=0;i<text.length()-1;i++){
			String sub=text.substring(i,i+2);
			if(pattern.compareTo(sub)==0)
				c++;
		}
		return c;
	}
}