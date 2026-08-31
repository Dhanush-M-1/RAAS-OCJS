import java.util.*;
public class MultiplyBy2DivBy6 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = sc.nextInt();
        while(tc != 0){
            int res = funct();
            System.out.println(res);
            tc--;
        }  
    }
    public static int funct(){
        int n = sc.nextInt();
        int count = 0;
        while(n!=1){
            if(n%6 == 0)
                n/= 6;

            else if(n%3==0)
                n = n*2;
            else{
                count = -1;
                break;
            }
            
            count++;
        }
        return count;
    }
}