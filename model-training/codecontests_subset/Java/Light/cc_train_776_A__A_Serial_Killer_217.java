import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		String s1 = cin.next();
		String s2 = cin.next();
		int n = cin.nextInt();
		System.out.println(s1+" "+s2);
		for(int i=0;i<n;i++){
			String s3 = cin.next();
			String s4 = cin.next();
			
			if(s3.equals(s1)) s1 = s4;
			if(s3.equals(s2)) s2 = s4;
			System.out.println(s1+" "+s2);
		}
	}
}