import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int a = s.nextInt();
	    int b = s.nextInt();
	    int a2=0,a3=0,a5 =0;
	    int b2=0,b3=0,b5 =0;
	    while(a%2==0){
	        a2++;
	        a =a/2;
        }
	    while(a%3==0){
	        a3++;
	        a /= 3;
        }
	    while(a% 5==0){
	        a5++;
	        a /= 5;
        }
        while(b%2==0){
            b2++;
            b =b/2;
        }
        while(b%3==0){
            b3++;
            b /= 3;
        }
        while(b% 5==0){
            b5++;
            b /= 5;
        }
        long res = -1;
        if(b==a){
            res = Math.abs(a2-b2)+Math.abs(a3-b3)+Math.abs(a5-b5);
            System.out.println(res);
        }
        else{
            System.out.println(-1);
        }
    }
}