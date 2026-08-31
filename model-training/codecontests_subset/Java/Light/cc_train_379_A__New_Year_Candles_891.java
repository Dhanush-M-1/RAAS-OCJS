import java.util.*;
public class div3 {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		int count=0;
		int counthr=0;
		while(a>0) {
			
			a--;
			count++;
			counthr++;
			if(count==b) {
				a++;
				count=0;
			}
		}
		System.out.println(counthr);
	}
}
