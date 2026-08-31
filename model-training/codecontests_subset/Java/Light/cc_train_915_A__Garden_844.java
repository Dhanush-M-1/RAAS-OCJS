import java.util.*;
public class Main{
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[] arr = new int[a];
        for(int i=0;i<a;i++){
            arr[i] = in.nextInt();
            if(b%arr[i]==0 && b/arr[i]<min){
                min = b/arr[i];
            }
        }
        System.out.print(min);
    }
}