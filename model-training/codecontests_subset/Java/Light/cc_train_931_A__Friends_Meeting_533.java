import java.util.Scanner;
public class Z006 {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int x1, x2, dif, ti1=0, ti2=0;
		int t=1;
		x1=input.nextInt();
		x2=input.nextInt();
		dif=Math.abs(x1-x2);
		while(dif>0){
			ti1=ti1+t;
			dif--;
			if(dif==0){
				break;
			}
			ti2=ti2+t;
			dif--;
			t++;
		}
		System.out.println(ti1+ti2);
	}

}
