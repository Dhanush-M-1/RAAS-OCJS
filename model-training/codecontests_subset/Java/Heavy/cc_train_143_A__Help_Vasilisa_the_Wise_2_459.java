import java.util.Scanner;
public class Main {
//A. Help Vasilisa the Wise 2
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int r1=in.nextInt();
        int r2=in.nextInt();
        int c1=in.nextInt();
        int c2=in.nextInt();
        int d1=in.nextInt();
        int d2=in.nextInt();
        
        int x=(r1-c2+d1)/2;
        int y=r1-x;
        int z=c1-x;
        int w=d1-x;
        if(x+y!=r1||z+w!=r2||x+w!=d1||y+z!=d2||x+z!=c1||y+w!=c2){
           System.out.println("-1");   
        }
     
        else if(x>0&&x<10&&y>0&&y<10&&z>0&&z<10&&w>0&&w<10&&x!=y&&x!=z&&y!=w&&z!=w&&x!=w&&y!=z){
        System.out.println(x+" "+y);
        System.out.println(z+" "+w);
        }
        else{
            System.out.println("-1");   
        }

    }

}