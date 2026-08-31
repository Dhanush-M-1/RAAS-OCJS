import java.util.Scanner;

public class competitive25 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        int k=in.nextInt();
        int c1=0,c2=0;
        c1=(k-n+1)/2;
        c2=(k-n+1)/3;
        if(c1>=c2 && c1!=0){
            System.out.println("2");
        }
        if(c2>c1){
            System.out.println("2");
        }
        if(c1==c2 && c1==0){
            System.out.println(k);
        }
    }
}
