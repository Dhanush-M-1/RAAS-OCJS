
import java.util.Scanner;






public class JavaApplication1 {

    


     
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    
    String a = sc.next();  String b = sc.next();
    int n = sc.nextInt();
    System.out.println(a + " "+b);
    for(int i=0; i<n; i++){
        String c = sc.next(); String d = sc.next();
        if(c.equals(a)){
            a = d;
        }else{
            b = d;
        }
        System.out.println(a+" "+b);
    }

    
    
    }
} 
