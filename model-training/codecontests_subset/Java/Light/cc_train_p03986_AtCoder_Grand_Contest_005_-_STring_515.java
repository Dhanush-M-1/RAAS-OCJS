import java.util.*;
class Main {
    public static void main(String[]$) {
        Scanner c=new Scanner(System.in);
        char[] x=c.next().toCharArray();
        int s=0,a=0;
        for(char t:x){
            a++;
            if(t=='S')s++;
            else if(s>0){
                s--;
                a-=2;
            }
        }
        System.out.print(a);
    }
}