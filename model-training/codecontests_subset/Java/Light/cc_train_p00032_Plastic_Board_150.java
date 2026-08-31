import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int rc = 0;
		int hc = 0;
		while(input.hasNext()){
			String[] st = input.next().split(",");
			int a1 = Integer.parseInt(st[0]);
			int a2 = Integer.parseInt(st[1]);
			int a3 = Integer.parseInt(st[2]);
			int length = a1*a1+a2*a2;
			if(length == a3*a3){
				rc++;
			}else if(a1 == a2 && a1+a2 > a3){
				hc++;
			}
		}
		System.out.println(rc);
		System.out.println(hc);
		input.close();
	}
}