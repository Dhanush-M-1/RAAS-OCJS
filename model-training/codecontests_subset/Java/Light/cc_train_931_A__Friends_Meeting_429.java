import java.util.Scanner;

public class BigInt {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int a=inp.nextInt() , b=inp.nextInt();
        int k = java.lang.Math.abs(b-a);
        if(k%2==0){
            System.out.println((k/2+1)*(k/2));
        }
        else{
            System.out.println((k/2+1)*(k/2+1));
        }


    }
}