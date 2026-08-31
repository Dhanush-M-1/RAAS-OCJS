import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	int H=0,W=0;

	do{
	    H=scan.nextInt();
	    W=scan.nextInt();
	    if(H==0 && W==0) break;
	    for(int i=0;i<H;i++){
		for(int j=0;j<W;j++){
		    if((i+j)%2==0){
			System.out.print("#");
		    }else{
			System.out.print(".");
		    }
		}
		System.out.println("");
	    }
	    System.out.println("");
	}while(H!=0 && W!=0);
    }
}

