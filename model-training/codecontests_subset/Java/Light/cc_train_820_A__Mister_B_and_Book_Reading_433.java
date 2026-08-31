import java.util.*;

public final class MisterBAndBookReading {
	static int c,v0,v1,a,l;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		v0 = sc.nextInt();
		v1 = sc.nextInt();
		a = sc.nextInt();
		l = sc.nextInt();
		int day =0 ;
		int readedPage = 0;
		while (readedPage < c) {
			day++;
			readedPage +=v0;
			if (day >= 2) {
				readedPage= readedPage - l;
			}
			if (v0+a<=v1){
				v0 = v0+a;
			}
			else v0 = v1;
		} 
		System.out.println(day);
	}
}