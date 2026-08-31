import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int rec=0,loz=0;
		while(sc.hasNext()){
			String[] st=sc.next().split(",");
			int a=Integer.parseInt(st[0]);
			int b=Integer.parseInt(st[1]);
			int d=Integer.parseInt(st[2]);
			if(a==b)loz++;
			if(a*a+b*b==d*d)rec++;
		}
		System.out.println(rec);
		System.out.println(loz);
	}
}