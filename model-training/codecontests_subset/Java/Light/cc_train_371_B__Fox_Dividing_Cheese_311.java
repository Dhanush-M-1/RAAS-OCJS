import java.util.*;

public class code {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();
        long y = scan.nextLong();
        int a,b,c,d,e,f;
        a = 0; b= 0; c=0; d=0; e=0; f=0;
        while(true){
            if(x%2==0){
                a++;
                x/=2;
            }
            else if(x%3==0){
                b++;
                x/=3;
            }
            else if(x%5==0){
                c++;
                x/=5;
            }
            else{
                break;
            }
        }
        while(true){
            if(y%2==0){
                d++;
                y/=2;
            }
            else if(y%3==0){
                e++;
                y/=3;
            }
            else if(y%5==0){
                f++;
                y/=5;
            }
            else{
                break;
            }
        }
        if(x!=y){
            System.out.println(-1);
        }
        else{
            System.out.print(Math.abs(a-d)+Math.abs(b-e)+Math.abs(c-f));
        }
    }
}
