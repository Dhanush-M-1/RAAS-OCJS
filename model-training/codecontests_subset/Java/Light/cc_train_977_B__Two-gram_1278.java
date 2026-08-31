import java.util.*;
public class Cf977B {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,i,max=0,c,j;
		n=sc.nextInt();
		String str=sc.next();
		String s="";
		char []ch= new char[n];
		ch=str.toCharArray();
		for (i=1;i<n;i++) {
			c=1;
			for (j=i;j<n-1;j++) {
				if(ch[j]==ch[i-1] && ch[j+1]==ch[i])
					c++;
			}
			if(c>max) {
				s=String.format("%c%c", ch[i-1],ch[i]);
				max=c;
			}
		}
		System.out.println(s);
		sc.close();
	}

}
