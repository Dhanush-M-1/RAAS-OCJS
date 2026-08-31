import java.util.Scanner;

/**
 *
 * @author Kraftco
 */
public class JavaApplication82 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner k=new Scanner(System.in);
        int x=k.nextInt();
        int []y=new int [x];
        double sum1=0,sum2=0;
        double count1=0,count2=0;
        for(int i=0;i<x;i++){
            y[i]=k.nextInt();
        }       
        for(int i=0;i<y.length;i++){
            if(y[i]==100){
               sum1+=y[i];
               count1++;}
            else{
               sum2+=y[i];
               count2++;}
        }
        if(count2%2==0){
          if(count1%2==0){
            System.out.println("YES");}
          else{
            System.out.println("NO");}
        }
        else{
            if((count1-2)%2==1 || (count1-2)<0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        
    }
    
}
