import java.util.Scanner;
public class Main {
	public static void main(String[] args) /*throws java.io.IOException*/ {
		Scanner scan = new Scanner(System.in);
		int Rhombus = 0;
		int Rectangle = 0;
		while(scan.hasNext()){
			String text = scan.next();
			String[] num = text.split(",", 0);
			int a = Integer.parseInt(num[0]);
			int b = Integer.parseInt(num[1]);
			int c = Integer.parseInt(num[2]);
			if(a*a + b*b == c*c){
				Rectangle++;
			}else if(a == b){
				Rhombus++;
			}
		}
		System.out.println(Rectangle);
		System.out.println(Rhombus);
	}
}