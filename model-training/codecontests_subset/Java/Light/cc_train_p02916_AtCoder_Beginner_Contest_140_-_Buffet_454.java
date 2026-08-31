import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n-1];
        int sum = 0;
 
        for(int i =0 ; i< n; i++ ){
            a[i] = sc.nextInt();
        }
 
        for(int i = 0;i<n;i++){
            b[i] = sc.nextInt();
        }
 
        for(int i = 0;i<n-1;i++){
            c[i] = sc.nextInt();
        }
 
        for(int i = 0; i<n;i++){
            sum += b[a[i]-1];
            if(i>0 && a[i]==a[i-1]+1){
                sum+=c[a[i]-2];
            }
        }
 
        System.out.println(sum);
		
	}
}
