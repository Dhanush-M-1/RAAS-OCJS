import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner std = new Scanner(System.in);
		int n = Integer.parseInt(std.next());

		int array[];
		array = new int[53];
		for(int i=1; i<=52; i++){
			array[i] = i;
		}

		for(int j=1; j<=n; j++){
			String suit = std.next();
			int rank = Integer.parseInt(std.next());
			if(suit.equals("S")) {rank+=0;}
			else if(suit.equals("H")) {rank+=13;}
			else if(suit.equals("C")) {rank+=26;}
			else if(suit.equals("D")) {rank+=39;}

			array[rank] = 0;
		}

		for(int i=1; i<=52; i++){
			if(array[i]!=0){
				String ret = "";
				if((i-1)/13==0){ret+="S ";}
				else if((i-1)/13==1){ret+="H ";}
				else if((i-1)/13==2){ret+="C ";}
				else if((i-1)/13==3){ret+="D ";}
				if(i%13!=0){ret += i%13;}else{ret+="13";}
				System.out.println(ret);
			}
		}
	}
}