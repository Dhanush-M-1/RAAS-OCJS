import java.util.Scanner;


public class Two_gram {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int r=sc.nextInt();
       String str=sc.next();
       char x[]=str.toCharArray();
       int max=0,max1=0;
       char a,b,c = 0,d = 0,q = 0,w = 0;
       
        for (int i = 0; i < r-1; i++) {
            a=x[i];
            b=x[i+1];
            
             for (int j= i ; j < r-1; j++) {
           
                 c=x[j];
                 d=x[j+1];
                 
            if(a==c&&d==b){
                max++;
                 }
            
        }
             
             if(max>max1){
            max1=max;
             q=a;
             w=b;
                
             }
              max=0;
              
            
        }
 
        System.out.println(q+""+w);
        
       
    }
    
}
