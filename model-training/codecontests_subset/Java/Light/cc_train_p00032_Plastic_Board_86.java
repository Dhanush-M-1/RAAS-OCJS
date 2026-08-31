import java.util.Scanner;


public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count_1 = 0,count_2 = 0;
		
		while(sc.hasNext()){
			String[] s = sc.nextLine().split(",");
			int len1 = Integer.parseInt(s[0]);
			int len2 = Integer.parseInt(s[1]);
			int len3 = Integer.parseInt(s[2]);
			if(len3*len3 == len1*len1 + len2*len2) count_1++;
			if(len1 == len2) count_2++;
		}
		System.out.println(count_1);
		System.out.println(count_2);
	}
}