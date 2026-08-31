import java.util.Arrays;
import java.util.Scanner;


public class JavaApplication103 {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,a=0,b=0;
        n=sc.nextInt();
        int ara1[]=new int[n];
        int ara2[]=new int[n-1];
        int ara3[]=new int[n-2];
        for(int i=0;i<n;i++){
            ara1[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++){
            ara2[i]=sc.nextInt();
        }
        for(int i=0;i<n-2;i++){
            ara3[i]=sc.nextInt();
        }
        Arrays.sort(ara1);
        Arrays.sort(ara2);
        Arrays.sort(ara3);
        for(int i=0;i<n-1;i++){
            if(ara1[i]!=ara2[i]){
                a=ara1[i];
                break;
            }
        }
        for(int i=0;i<n-2;i++){
            if(ara2[i]!=ara3[i]){
                b=ara2[i];
                break;
            }
        }
        if(a==0){
            a=ara1[n-1];
        }
        if(b==0){
            b=ara2[n-2];
        }
        System.out.println(a);
        System.out.println(b);
    }
    
}