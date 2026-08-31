import java.util.*;


public class Test{
    

    public static void main(String args[]) {
     Scanner in = new Scanner(System.in); 
     int c1=in.nextInt(),c2=in.nextInt(),c3=in.nextInt(),c4=in.nextInt(),c5=in.nextInt();
    
     if(c1==c2 && c2==c3 && c3==c4 && c4==c5 && c1==0)
            System.out.println("-1");
     else   if((c1+c2+c3+c4+c5)%5 == 0)
            System.out.println((c1+c2+c3+c4+c5)/5);
     else
            System.out.println("-1");
   
   
   
   
   
   
   
   
   
    }
}
