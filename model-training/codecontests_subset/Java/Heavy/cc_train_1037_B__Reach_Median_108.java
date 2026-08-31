import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        long s=in.nextLong();
        int k=n/2;
        long count=0;
        long[] a= new long[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextLong();
        }
        Arrays.sort(a);
        if(s>a[k]){
            for(int j=k;j<n;j++){
                if(s>a[j]) {
                    count = count + s - a[j];
                }
            }

        }else if(s<a[k]){
            for(int j=k;j>=0;j--){
                if(s<a[j]) {
                    count=count+a[j]-s;
                }
            }
        }
        System.out.println(count);

    }
}
