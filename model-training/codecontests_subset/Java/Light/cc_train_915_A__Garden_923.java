
import java.util.Arrays;
import java.util.Scanner;

/*
_Сад
*/
public class A915 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            int a=arr[arr.length-1-i];
            if(k%a==0){System.out.println(k/a);break;}
        }
        
    }
}
