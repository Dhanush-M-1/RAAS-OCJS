
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NewClass {
    public static int min(List <Integer>a){
    int m=a.get(0);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)< m) {
                m=a.get(i);
            }
        }
    return m;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(),k=s.nextInt();
       
        List <Integer>a=new ArrayList(); 
        for (int i = 0,c=0; i < n; i++)
        {
          c=  s.nextInt();
            if (k% c==0) a.add(k/c);  
        }
        
        System.out.println(min(a));
            
        
       
    }

}
