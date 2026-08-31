import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        int len = x.length();
        int res = 0;
        int numS = 0;
        for(int i=0;i<len;i++){
            if(x.charAt(i)=='S') numS++;
            else{
                if(numS>0){
                    numS--;
                    res += 2;
                }
            }
        }
        System.out.println(len-res);
    }
}
