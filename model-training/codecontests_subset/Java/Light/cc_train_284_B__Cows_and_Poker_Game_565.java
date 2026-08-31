import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String line = in.next();
        long A=0, I=0, F=0;
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='A') A++;
            else if(line.charAt(i)=='I') I++;
            else F++;
        }
        if(I==0) System.out.println(A);
        else if(I==1) System.out.println("1");
        else System.out.println("0");
        
    }

}