import java.util.Scanner;

public class test1 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = a;
        int s = 0;
        int z = x%b;
        x = x/b;
        
        s = s + x;
        x = x+z;
        
        while(x>=b){
            //System.out.println(x+" "+s);
            z = x%b;
            x = x/b;
             //System.out.println(z+" "+x);
            s = s+x;
            x = x+z;
            //System.out.println(x+" "+s);
            
        }
        System.out.println(a+s);
        
    }

}
