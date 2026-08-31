
import java.util.Scanner;
 
public class HelpVasilisaTheWise2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int lock[] = new int[6];
        int min[] = {10,0};
        int sol [] = new int [4];
        for(int i=0; i < 6 ;i++){
            lock[i]=cin.nextInt();
        }
        boolean key = false;
        for(int i=1 ; i < lock[0]; i++){
            sol[0]=i;
            sol[1]=lock[0]-i;
            sol[2]=lock[2]-i;
            sol[3]=lock[4]-i;
            if( (sol[0]+sol[1]==lock[0]) && (sol[0]+sol[2]==lock[2]) && (sol[0]+sol[3]==lock[4]) && (sol[1]+sol[3]==lock[3])
            && (sol[2]+sol[1]==lock[5]) && (sol[2]+sol[3]==lock[1])&& sol[0]!=sol[1]&& sol[0]!=sol[2]&& sol[0]!=sol[3] &&
                    sol[1]!=sol[2]&& sol[1]!=sol[3]&& sol[2]!=sol[3]&&sol[0]<10&&sol[1]<10&&sol[2]<10&&sol[3]<10&&sol[0]>0&&sol[1]>0&&sol[2]>0&&sol[3]>0){
                key=true;
                break;
            }
        }
        if(key) {
            System.out.println(sol[0] + " " + sol[1]);
            System.out.println(sol[2] + " " + sol[3]);
        }
        else
            System.out.println(-1);
    }
}
