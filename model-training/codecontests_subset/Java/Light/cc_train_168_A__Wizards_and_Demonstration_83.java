import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ICPC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        int c= (int) Math.ceil((double)y*n/100.0);
        if((c-x)>=0){
            System.out.println((c-x));
        }else{
            System.out.println(0);
        }



    }
}

  	 					    	    	 	 	 		 		