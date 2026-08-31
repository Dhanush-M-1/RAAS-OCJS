import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        char[] arr=scan.next().toCharArray();
        int one=0,zero=0;
        for (int i = 0; i <n ; i++) {
            if (arr[i]=='1'){
                one++;
            }else {
                zero++;
            }
        }
        if (one!=zero){
            System.out.println(1);
            System.out.println(arr);
            return;
        }
        System.out.println(2);
        System.out.print(arr[0]+" ");
        for (int i = 1; i <n ; i++) {
            System.out.print(arr[i]);
        }
    }
}


