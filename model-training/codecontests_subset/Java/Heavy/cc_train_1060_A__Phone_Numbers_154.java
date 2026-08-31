


import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String s = in.next();
        int num=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '8')
                num++;
        }
        if(num != 0 && a > 10){
        int z = a/11;
        int h = 0;
        int u = z;
        while(u != 0 && num != 0)
        {
            if(u > 0 && num > 0){
               h++;
               --u;
               --num;
            }
        }
    
            System.out.println(h);
        }  else
             System.out.println(0);
    }
    
}
