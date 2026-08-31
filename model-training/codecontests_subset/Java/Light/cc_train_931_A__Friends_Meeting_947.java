import java.io.*;
import java.util.*;

public class FriendsMeeting{
    
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int x = in.nextInt();
        int y = in.nextInt();
        int xt = 1;
        int yt = 1;
        int total = 0;
        
        int i=x, j=y;
        
        if(x>y){
            i = y;
            j = x;
        }
        
        while(i!=j){
            if(xt <= yt){
                i++;
                total += xt++;
            }else{
                j--;
                total += yt++;
            }
        }
        
        System.out.println(total);
    
    }
}