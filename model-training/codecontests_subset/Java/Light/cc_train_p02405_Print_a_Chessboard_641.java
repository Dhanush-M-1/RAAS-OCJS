import java.util.Scanner;

public class Main{
    public static void main(String[] ss){
        int h,w,i,j;
        Scanner s = new Scanner(System.in);
        while(true){
        h = s.nextInt();
        w = s.nextInt();
        if(h*w==0)break;
        for(i=1;i<=h;i++){
            for(j=1;j<=w;j++){
                if((i+j)%2==0)System.out.print("#");
                else System.out.print(".");
            }
                System.out.println();
            }
            System.out.println();
        }
    }
}
