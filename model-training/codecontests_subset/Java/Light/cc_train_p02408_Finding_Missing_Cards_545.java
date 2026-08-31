import java.util.Arrays;
import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		boolean[] card=new boolean[52];
		Arrays.fill(card,false);
		String[] c= {"S","H","C","D"};
		for(int i=0; i<N; i++) {
			String s=sc.next();
			int suji=sc.nextInt();
			if(s.equals(c[0])) {
				card[suji-1]=true;
			}
			else if(s.equals(c[1])) {
				card[13+suji-1]=true;
			}
			else if(s.equals(c[2])) {
				card[26+suji-1]=true;
			}
			else if(s.equals(c[3])) {
				card[39+suji-1]=true;
			}
		}
		for(int i=0; i<52; i++) {
			if(!card[i]) {
				System.out.println(c[i/13]+" "+(i%13+1));
			}
		}
	}
}
