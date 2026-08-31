import java.util.Arrays;
import java.util.Scanner;

public class Main{
	
	static final Scanner s=new Scanner(System.in);
	
	public static void main(String[] __){
		int
		in[]={s.nextInt(),s.nextInt(),s.nextInt()},
		sum=Arrays.stream(in).sum();
		
		System.out.println(sum%2==0&&Arrays.stream(in).anyMatch(i->i==sum/2)?"Yes":"No");
	}
}
