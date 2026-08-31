import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int n = s.nextInt();
	    int k = s.nextInt();
	    int[] a = new int[n+1];
	    for(int i=1;i<=n;i++){
	        a[i] = s.nextInt();
        }
	    int chill = 0;
	    for(int i=1;i<=n;i++){
	        chill += i;
	        if(chill>=k){
	            int diff = chill - k;
                System.out.println(a[i-diff]);
                break;
            }
	    }
    }
}
