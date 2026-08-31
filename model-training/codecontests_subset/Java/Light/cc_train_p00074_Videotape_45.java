import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int h = 2;
    	int m = 0;
    	int s = 0;
        while(scan.hasNext()){
        	int sh = scan.nextInt();
        	int sm = scan.nextInt();
        	int ss = scan.nextInt();
        	if(sh == -1 && sm == -1 && ss == -1){
        		break;
        	}
        	h = 2;
        	m = 0;
        	s = 0;
        	h -= sh;
        	m -= sm;
        	s -= ss;
        	if(s < 0){
        		m--;
        		s += 60;
        	}
        	if(m < 0){
        		h--;
        		m += 60;
        	}
        	System.out.printf("%02d:%02d:%02d\n",h,m,s);
        	h *= 3;
        	m *= 3;
        	s *= 3;
        	if(s >= 60){
        		m += s/60;
        		s %= 60;
        	}
        	if(m >= 60){
        		h += m/60;
        		m %= 60;
        	}
        	System.out.printf("%02d:%02d:%02d\n",h,m,s);
        }
    }
}