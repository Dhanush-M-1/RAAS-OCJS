import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int Q =s.nextInt();
        while (Q>0){
            Q--;

            int N =s.nextInt();
            int num=0;

            while(N>9){
                num++;
                int max=0;

                for(int i=1;i<String.valueOf(N).length();i++) {
                    int div1 = N/(int)(Math.pow(10,i));
                    int div2 = N%(int)(Math.pow(10,i));
                    if(max<div1*div2){
                        max=div1*div2;
                    }
                }
                N=max;
            }
            System.out.println(num);
        }
    }
}