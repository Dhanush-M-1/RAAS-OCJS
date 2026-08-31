import java.util.*;
public class Main {
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	// 整数の入力
	long n = sc.nextLong();
	long p = sc.nextLong();

	long ans = 1;
	long cnt;

	if(n == 1){
	    ans = p;
	}else{

	    cnt = 0;
	    for(;;){
		if(p % 2 == 0){
		    cnt++;
		    p /= 2;
		}else{
		    for (int j = 1; j <= cnt / n; j++){
			ans *= 2;
		    }
		    break;
		}
	    }


	for(int i = 3; Math.pow(i, n) <= p;i+=2){

	    cnt = 0;
	    for(;;){
		if(p % i == 0){
		    cnt++;
		    p /= i;
		}else{
		    for (int j = 1; j <= cnt / n; j++){
			ans *= i;
		    }
		    break;
		}
	    }
	}
	}
 
	System.out.println(ans);
    }
}
 