
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
/**
 *
 * @author ganes
 */
public class Program {

    /**
     * @param args the command line arguments
     */
   public static void main(String []args){
        Scanner input = new Scanner(System.in);
        String s= input.nextLine();
        String x[]= s.split("\\+");
        int j,i=0;
        String s1="";
        int a[]={0,0,0,0};
        for(i=0;i<x.length;i++){
//            char c=s.charAt(i);
            if(x[i].equals("1")){a[1]++;}
            else if(x[i].equals("2")){a[2]++;}
            else{a[3]++;}
        }
        for(i=1;i<=3;i++){
            for(j=1;j<=a[i];j++){
                if(s1==""){s1=s1+""+i;}
                else{s1=s1+"+"+i;}
            }
        }
        s1=s1.replaceFirst("//+", "");
        System.out.println(s1);
     }
    
}