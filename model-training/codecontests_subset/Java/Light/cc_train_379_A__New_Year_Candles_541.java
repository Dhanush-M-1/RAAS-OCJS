import java.util.Scanner;
public class A379 {
    public static Scanner s=new Scanner(System.in);

    public static void main(String[] args) {
        int a=s.nextInt();
        int b=s.nextInt();
        int av=a,bur=0;
        int c=0;
        while(true){
            if(av!=0){
                c++;
                av--;
                bur++;
            }
            if(bur==b){
                bur=0;
                av++;
            }
            if(av==0) break;
        }
        System.out.println(c);
    }
}