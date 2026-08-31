import java.util.Scanner;

public class PhoneNumbers {

    
    public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
      int n,c=0;
      String s;
      n=input.nextInt();
      s=input.next();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='8'){
                c++;
            }
        }
        if(n>=11 && c>0){
            if((n/11)>c){
                System.out.println(c);
            }else{
                 System.out.println(n/11);
            }
        }else{
             System.out.println("0");
        }
    }
    
}
