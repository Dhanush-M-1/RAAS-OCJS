import java.util.Scanner;

public class KingOfThieves {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
           int n=in.nextInt();
           String s=in.next();
           int star=5*'*';
         char  ch[]=s.toCharArray();
            for(int j=1;j<n;j++)
           for(int i=0;i<n;i++)
           {
               if(i+j>n||i+j*2>n||i+j*3>n||i+j*4>n)
                   break;
               try {  
               
 
               if(ch[i]+ch[i+j]+ch[i+j*2]
                       +ch[i+j*3]+ch[i+j*4]==star){
                   System.out.println("yes");System.exit(0);
  
              }} catch (Exception e) {
               }
           }
            
           //
           System.out.println("no");
        
    }
    
}