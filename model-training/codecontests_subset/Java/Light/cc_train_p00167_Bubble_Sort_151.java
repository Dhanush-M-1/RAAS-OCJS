import java.util.*;

public class Main{
    Main(){
	Scanner sc = new Scanner(System.in);

	while(sc.hasNext()){
	    int n = sc.nextInt(), cnt=0, t;
	    if(n == 0) break;
	    int[] a = new int[n+1];
	    for(int i = 0; i < n; i++) a[i] = sc.nextInt();

	    for(int i = n-1; i > 0; i--)
		for(int j = 1; j <= i; j++)
		    if(a[j-1] > a[j]){
			t = a[j-1];
			a[j-1] = a[j];
			a[j] = t;
			cnt++;
		    }

	    System.out.println(Integer.toString(cnt));
	}
    }

    public static void main(String[] args){
	new Main();
    }
}