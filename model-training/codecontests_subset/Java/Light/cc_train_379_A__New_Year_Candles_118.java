import java.util.Scanner;
public class Main {

  
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       int a=s.nextInt();
       int b=s.nextInt();
       int res=a;
       while(a>=b){
           res+=a/b;
           a=a%b+a/b;
           
       }
       System.out.println(res);
        
    }
    
}
