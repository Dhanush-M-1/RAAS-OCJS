import java.util.Arrays;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] evenAr = new int[n];
        int[] oddAr = new int[n];
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++){
            int a = in.nextInt();
            if(a%2==0) evenAr[even++] = a;
            else oddAr[odd++] = a;
        }


        int output = 0;

        Arrays.sort(evenAr, 0, even);
        Arrays.sort(oddAr, 0, odd);
        if(even>odd){
            for(int i = 0; i < even-odd-1; i++){
                output+=evenAr[i];
            }
        }
        else{
            for(int i = 0; i < odd-even-1; i++){
                output+=oddAr[i];
            }
        }

        System.out.println(output);


    }









}
