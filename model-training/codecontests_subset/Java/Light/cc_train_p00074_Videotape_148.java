//Volume0-0074
import java.util.*;

public class Main {
	
    //declare
	private static final int H   = 3600,
    	                     M   =   60,
    	                     END =   -3;

    public static void main(String[] args) {
    	
    	int h,m,s,time;
    	String[] str;

    	//input
    	Scanner sc = new Scanner(System.in);
    	while(true){
    		str = sc.nextLine().split("\\s");
    		h = Integer.parseInt(str[0]);
    		m = Integer.parseInt(str[1]);
    		s = Integer.parseInt(str[2]);
    		if(h+m+s == END){break;}
    		
    		//calculate
    		time = H * 2 - (h * 3600 + m * 60 + s);
    		
    		//output
    		print(time);
    		print(time*3);
    	}
    }
    
    private static void print(int time){
    	int h,m,s,t;
    	h = time / H;
    	t = time % H;
    	m = t / M;
    	s = t % M;
    	System.out.printf("%02d:%02d:%02d\n",h,m,s);
    }
}