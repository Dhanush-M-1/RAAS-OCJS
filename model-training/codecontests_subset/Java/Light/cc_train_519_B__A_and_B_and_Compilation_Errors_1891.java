import java.util.Scanner;


public class Main{
    public static void main(String args[])
    {
        Scanner cs= new Scanner(System.in);
        int arr [] = new int [3],n,a,i,j;
        n = cs.nextInt();
        for (i = 0; i < 3; i++) {
            for (j = i; j< n;j++) {
                a = cs.nextInt();
                arr[i]+=a;
            }
        }
        System.out.println(arr[0]-arr[1]);
        System.out.println(arr[1]-arr[2]);
    }
}
