import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int count1=0,count2=0,i,j,a,b,c,x,y;
		while(s.hasNext()){
			String[] str=s.next().split(",");
			a=Integer.parseInt(str[0]);
			b=Integer.parseInt(str[1]);
			c=Integer.parseInt(str[2]);
			x=c*c;y=a*a+b*b;
			if(x==y) count1++;
			if(a==b) count2++;
		}
		System.out.println(count1);
		System.out.println(count2);
	}
}