import java.util.Scanner;
 
public class Main{
    public static void main(String[] args){
        Scanner key = new Scanner(System.in);
        
        int a = key.nextInt();
        key.nextLine();
        String s = key.nextLine();
        
        int count1=0,count0=0;
        for(int i = 0;i<a;i++)
        {
            if(s.charAt(i) == '1')
            {
                count1++;
            }
            
            if(s.charAt(i) == '0')
            {
                count0++;
            }
        }
        
        if(count0 != count1)
        {
            System.out.print("1" + "\n" + s);
        }
        else
        {
            System.out.print("2" + "\n" + s.charAt(0) + " ");
            for(int i=1;i<a;i++){
                System.out.print(s.charAt(i));
            }
        }
    }
}