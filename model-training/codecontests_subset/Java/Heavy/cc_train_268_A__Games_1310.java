import java.util.*;
public class Main {


    public static void main(String[] args) {
       Scanner S= new Scanner(System.in);
       int n=S.nextInt();
       int[][]hg=new int[n][2];
       for(int i=0;i<n;i++){
           hg[i][0]=S.nextInt();
           hg[i][1]=S.nextInt();
       }
       int c=0;
       for(int i=0;i<n-2;i++){
           for(int j=i+1;j<n;j++){
               if(hg[i][0]==hg[j][1]){
                   c++;
               }
               if(hg[i][1]==hg[j][0]){
                   c++;
               }
           }
           
                
       }
       if(hg[n-2][0]==hg[n-1][1]){
                   c++;
               }
       
           if(hg[n-2][1]==hg[n-1][0]){
                   c++;
               }
       System.out.println(c);
       
       
       
       
    }

}
