import java.util.*;
//import java.lang.Math;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            int H=sc.nextInt();
            int W=sc.nextInt();
            if(H+W==0) break;
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++) System.out.print((i+j)%2==1?'.':'#');
                System.out.println();
            }
            System.out.println();
        }
    }
}
