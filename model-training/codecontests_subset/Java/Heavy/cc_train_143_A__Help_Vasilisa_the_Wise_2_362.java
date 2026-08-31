
import java.util.Scanner;


public class HelpVasilisatheWise2 {

    
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] num=new int[6];
        int i;
        for(i=0;i<6;i++){
            num[i]=in.nextInt();
        }
        for(i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                if(i==j)continue;
                for(int x=1;x<=9;x++){
                    if(i==x||x==j)continue;
                    for(int y=1;y<=9;y++){
                        if(i==y||x==y||j==y)continue;
                        if(i+j==num[0]&&x+y==num[1]&&i+x==num[2]&&j+y==num[3]&&i+y==num[4]&&j+x==num[5]){
                            System.out.println(i+" "+j);
                            System.out.println(x+" "+y);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
    
}