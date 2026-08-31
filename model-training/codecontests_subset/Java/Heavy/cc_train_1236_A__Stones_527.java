import java.util.Scanner;
public class abc{
    public static void fun(int a,int b,int c){
        int ans=0;
        while(b>=1&&c>=2){
            ans+=3;
            b--;
            c=c-2;
        }
        while(a>=1&&b>=2){
            ans+=3;
            a--;
            b=b-2;
        }
        System.out.println(ans);
        
    }
    public static void main(String[] args){
        Scanner read=new Scanner(System.in);
        int t=read.nextInt();
        int a,b,c;
       while(t>0){
           a=read.nextInt();
           b=read.nextInt();
           c=read.nextInt();
           fun(a,b,c);
           t--;
       }
       read.close();
    

    }
}