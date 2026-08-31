import java.util.Arrays;
import java.util.Scanner;

public class CodeforcesSolutions1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n =sc.nextInt();
        while (n >  0 ){
            int a = sc.nextInt();
            int b =sc.nextInt();
            int res[]= new int[1];
            int arr[]=new int[a];
            int brr[]=new int[b];
            for(int i=0;i<a;i++){
                arr[i]=sc.nextInt();
            }
            for(int i=0;i<b ;i++){
                brr[i]=sc.nextInt();

            }
            for(int i=0;i<a;i++){
                for(int j=0;j<b ;j++){
                    if(arr[i]==brr[j]){
            res[0]=arr[i];
            brr[j]=0;
            break ;


                    }
                }
            }
            if(res[0]!=0 ){
                System.out.println("YES");
                System.out.println("1 "+ res[0]);
            }
            else {
                System.out.println("NO");
            }
            n--;
        }
    }
}