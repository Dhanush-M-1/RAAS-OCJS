//Volume2-0206
import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		//declare
		int     L,ret;
		boolean flg;

		//input
        Scanner sc = new Scanner(System.in);
        while(true){
            L = sc.nextInt();
            if(L==0){break;}

            //calculate
            ret = 0;
            flg = false;
            for(int i=0;i<12;i++){
            	if((L -= (sc.nextInt() - sc.nextInt())) <= 0 && !flg){
            		ret = i+1;
            		flg = true;
            	}
            }

            //output
            if   (ret > 0){System.out.println(ret) ;}
            else          {System.out.println("NA");}
        }
	}
}