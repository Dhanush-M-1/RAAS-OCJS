
import java.util.Scanner;
public class EquivalentStrings {
    
   public static String mergeSort(String a){
        if(a.length()%2==1) return a;
        String x ,y ;
        x=mergeSort(a.substring(0 , a.length()/2));
        y=mergeSort(a.substring(a.length()/2, a.length()));
        if (x.compareTo(y)<0) return x+y;
        else return y+x;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        
        if(s1.length()!=s2.length()){
            System.out.print("NO");
            return;
        }
         if(s1.compareTo(s2)==0){
            System.out.println("YES");
            return;      
        }
        if(s1.length()%2!=0){
            System.out.println("NO");
            return;        
        }         
        if (mergeSort(s1).compareTo(mergeSort(s2))==0){
             System.out.println("YES");
             return;
        }     
        else{
            System.out.println("NO");
             return;
        }               
    }    
}
        


