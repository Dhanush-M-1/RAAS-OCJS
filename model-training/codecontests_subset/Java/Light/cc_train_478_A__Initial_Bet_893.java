import java.util.Scanner;
public class Binarysearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum =0;
        int[] a = new int[5];
        for(int i=0;i<5;i++){
            a[i] = input.nextInt();
            sum+=a[i];
        }
        if(sum%5==0 && sum!=0) System.out.printf("%d\n",sum/5);
        else System.out.printf("%d\n",-1);
         
    }
}