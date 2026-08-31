import java.util.Scanner;
import java.util.Arrays;

public class HelpfulMaths {

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String x=s.next();
       
        int o=x.length();
        int temp;
        char[]y=new char[o];
        int []z=new int[o];
        
        for(int i=0;i<o;){
          y[i]=x.charAt(i);
          z[i]=Character.getNumericValue(y[i]) ;  
          i=i+2;  
        }
        Arrays.sort(z);
       for(int i=0;i<o-1;i++){
           if(z[i]!=0)
          System.out.print(z[i]+"+");
       }
        System.out.print(z[o-1]);

       } 
    }