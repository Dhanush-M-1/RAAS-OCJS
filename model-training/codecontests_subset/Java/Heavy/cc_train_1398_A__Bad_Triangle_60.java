import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author DELL
 */
public class Coding {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc=new Scanner(System.in);
         int t=sc.nextInt();
         while(t-->0){
             int n=sc.nextInt();
             int a[]=new int[n];
             for(int i=0;i<n;i++){
                 a[i]=sc.nextInt();
             }
             int l=0,m=0,k=0;
             int temp=a[0]+a[1];
             boolean f=false;
             for(int i=2;i<n;i++){
                 if(a[i]>=temp){
                     f=true;
                     l=i+1;
                     break;
                 }
             }
             if(f){
                 System.out.println("1"+" "+"2"+" "+l);
             }
             else{
                 System.out.println("-1");
             }
         }
    }
}