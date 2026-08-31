import java.util.*;
public class Stringproplm {   
    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int c=0;
        int arr[]=new int[n];
        int ar[]=new int[n];
        for (int i = 0; i <n; i++) {
            arr[i]=in.nextInt();
            ar[i]=in.nextInt();
        }
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <ar.length; j++) {
                if(arr[i]==ar[j]){
                    c++;
                }
            }
        }
        System.out.println(c);
}
}      