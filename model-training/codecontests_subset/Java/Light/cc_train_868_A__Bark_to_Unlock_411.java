import java.util.Scanner;

public class Chong{
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String pass = in.next();
		int num = in.nextInt();
		String [] ar = new String[num];
		for(int i = 0; i < num; i++){
			ar[i] = in.next();
		}
		for(String item1: ar){
			for(String item2: ar){
				if((item1 + item2).contains(pass)){
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}           
}