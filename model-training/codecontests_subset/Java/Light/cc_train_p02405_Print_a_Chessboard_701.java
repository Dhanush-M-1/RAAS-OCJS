import java.util.Scanner;

public class Main{
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        while(true){
            int i,j;
            int h=sc.nextInt();
            int w=sc.nextInt();
            if(h==0 && w==0)break;
            for(i=0;i<h;i++){
                for(j=0;j<w;j++){
                    if((i%2==0 && j%2==0) || (i%2==1 && j%2==1))System.out.printf("#");
                    else System.out.printf(".");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
