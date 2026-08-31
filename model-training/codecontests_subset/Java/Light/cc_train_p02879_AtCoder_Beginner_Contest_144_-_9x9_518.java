import java.util.*;
class Main{
    public static void main(String[] args){
	Scanner stdIn = new Scanner(System.in);
	int A = stdIn.nextInt();
	int B = stdIn.nextInt();
	if(A>0&&A<10&&B>0&&B<10){
	    System.out.println(A*B);
	}else{
	    System.out.println(-1);
	}
    }
}
