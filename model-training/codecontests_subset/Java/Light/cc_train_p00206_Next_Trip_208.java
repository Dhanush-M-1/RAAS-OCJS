

import java.util.Scanner;
 
class Main{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int L=sc.nextInt(), sum = 0;
            if (L==0)break;
            boolean finish=false;
            for (int i=0;i<12;i++){
                sum += sc.nextInt() - sc.nextInt();
                if (!finish&&sum>=L) {
                    System.out.println(i + 1);
                    finish=true;
                }
            }
            if (!finish)System.out.println("NA");
     
        }
    }
}