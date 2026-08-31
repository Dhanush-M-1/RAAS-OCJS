import java.util.*;

public class Main{
    public static void main(String args []){
	Scanner in = new Scanner(System.in);

	while(true){
	    int n = in.nextInt();
	    if(n == 0) break;

	    int [] a = new int [n];
	    for(int i = 0 ; i < n ; i++){
		a[i] = in.nextInt();
	    }

	    int ans = 0;
	    for(int i = n-1 ; i > 0 ; i--){
		for(int j = 0 ; j < i ; j++){
		    if(a[j] > a[j+1]){
			int tmp = a[j];
			a[j] = a[j+1];
			a[j+1] = tmp;
			ans++;
		    }
		}
	    }
	    System.out.println(ans);
	}
    }
}