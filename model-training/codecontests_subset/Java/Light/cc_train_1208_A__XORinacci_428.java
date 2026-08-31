import java.util.*;

public class DD {

    public static void main(String[] args) {
        // TODO code application logic here
        

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++){
            int n0=sc.nextInt();
            int n1=sc.nextInt();
            int n2=n0^n1;
            int h=sc.nextInt();
            int p=h%3;
            if(p==0){
                System.out.println(n0);
            }
            else if(p==1){
                System.out.println(n1);           
            }
            else{
                System.out.println(n2);
            }
        }
    }
    
}
