import java.util.*; 
public class Main{
    public static void main(String[] args){
           Scanner bien=new Scanner(System.in); 
           int t=bien.nextInt(); 
           while(t>0){
           	int x=bien.nextInt(); 
           if(x==1){
               System.out.println(0);
           }
           else{
               int d=0; int c=0; 
           while(x!=1){
               if(x%3!=0){
                   c++;
               System.out.println(-1);x=1;continue;
              }
               if(x%6==0) {
                   x=x/6;
                   d++;}
               else {
                   x=x*2;d++;}
           }
            if(c==0)System.out.println(d);
           }
           	t--;
		   }
    }
}
