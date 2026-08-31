
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	double c = sc.nextInt();
	double v0 = sc.nextInt();
	double v1 = sc.nextInt();
	double a = sc.nextInt();
	double l = sc.nextInt();
	double booknow = 0;
	int day=0;
	while(booknow<c) {
		day++;
		if(day>1) booknow-=l;
		double vnow = v0+(day-1)*a;
		if(vnow>=v1) vnow=v1;
		booknow+=vnow;
	}
	System.out.println(day);
}
}
