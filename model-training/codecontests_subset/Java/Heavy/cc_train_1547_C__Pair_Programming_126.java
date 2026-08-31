import java.util.Scanner;

/**
 *
 * @author anurag
 */
public class A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        
        for(int i=0;i<t;i++){
            
           String str=sc.nextLine();
           
           int k=sc.nextInt();
           int n=sc.nextInt();
           int m=sc.nextInt();
           
           int a[]=new int[n];
           
           for(int x=0;x<n;x++){
               a[x]=sc.nextInt();
           }
           int b[]=new int[m];
           for(int y=0;y<m;y++){
               b[y]=sc.nextInt();
           }
           
           int x=0;
           int y=0;
           int flag=0;
           String s="";
           
           while(x<n || y<m){
               
               if(x<n && a[x]==0){
                   k++;
                   if(s.length()>0){
                       s+=" ";
                   }
                   s+=a[x];
                   x++;
               }else if(y<m && b[y]==0){
                   k++;
                   if(s.length()>0){
                       s+=" ";
                   }
                   s+=b[y];
                   y++;
               }else{
                   
                   if(x<n && a[x]<=k){
                       if(s.length()>0){
                           s+=" ";
                       }
                       s+=a[x];
                       x++;
                   }else if(y<m && b[y]<=k){
                       if(s.length()>0){
                           s+=" ";
                       }
                       s+=b[y];
                       y++;
                   }else{
                       flag=1;
                       break;
                   }
               }
           }
           
           if(flag==0){
               System.out.println(s);
           }else{
               System.out.println("-1");
           }
           
        }
    }
    
}
