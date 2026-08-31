import java.util.Scanner;

public class Main{
    public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	int H = s.nextInt();
	int W = s.nextInt();

	while(H != 0 || W != 0){
	    for(int i = 0; i < H; i++){
		for(int j = 0; j < W; j++){
		    if((i + j) % 2 == 0) System.out.print("#");
		    else System.out.print(".");
		}
		System.out.println();
	    }
	    System.out.println();

	    H = s.nextInt();
	    W = s.nextInt();
	}
    }
}

