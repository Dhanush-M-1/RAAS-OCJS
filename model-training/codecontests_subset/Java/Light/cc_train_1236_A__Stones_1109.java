import java.util.Scanner;
public class hesp {
    public static void main(String[] args) {
        
    
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
  
    
    for(int i = 0 ; i<n ; i++){
        int sum = 0;
         int  a = sc.nextInt();
           int b = sc.nextInt();
           int c = sc.nextInt();
           while(c>=2 && b>=1){
               sum+=3;
               c-=2;
               b-=1;
           }
               
           while(a>=1 && b>=2){
               sum+=3;
               b-=2;
               a-=1;
           }
           System.out.println(sum);
           
           
}
    
}
}
    


