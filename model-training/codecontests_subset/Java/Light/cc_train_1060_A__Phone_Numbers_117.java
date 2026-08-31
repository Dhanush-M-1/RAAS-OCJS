import java.util.Scanner;
public class Project2 {
    public static void main(String[] arg) {
       Scanner sc =new Scanner(System.in);
       int ko = sc.nextInt()/11;
       String bo = sc.next();
        int num = 0;
        for(int i =0;i<bo.length();++i){
           if(bo.charAt(i)=='8') {
               ++num;
           }

        }
        if(num>=ko){
            System.out.println(ko);
        }
        else{
            System.out.println(num);
        }
    }
}