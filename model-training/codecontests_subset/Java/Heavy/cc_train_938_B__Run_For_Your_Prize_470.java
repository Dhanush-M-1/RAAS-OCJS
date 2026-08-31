import java.util.Scanner;
public class dad {


        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            int b=0;
            int i=0;
            int seconds=0;
            int seconds1=0;
            while(i<a) {
                b = sc.nextInt();
                if(b<=500000){
                    seconds=b-1;
                }else{
                    if(1000000-b>seconds1)
                    seconds1=1000000-b;
                }
                i++;
            }
            if(seconds1>seconds)
            System.out.print(seconds1);
            else
                System.out.print(seconds);
        }


}
