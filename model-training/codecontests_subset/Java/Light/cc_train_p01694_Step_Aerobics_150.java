import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			if(n == 0) break;
			boolean state = false;
			int count = 0;
			boolean left = false;
			boolean right = false;
			for(int i=0; i<n; i++){
				char[] f = in.next().toCharArray();
				if(f[0] == 'l') left = !left;
				else right = !right;
				if(right == left){
					if(left != state){
						count++;
						state = left;
					}
				}
			}
			System.out.println(count);
		}
	}
}