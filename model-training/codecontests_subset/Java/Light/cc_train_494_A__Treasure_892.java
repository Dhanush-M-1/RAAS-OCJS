import java.io.*;
import java.util.*;

public class problem495C{
    public static void main(String[]args)throws IOException{
        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        String s=x.readLine();
        int countones=0;
        int surplus=0;
        int save=0;
        int savei=0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(')surplus++;
            if (s.charAt(i)==')')surplus--;
            if (s.charAt(i)=='#'){
                surplus--;
                countones++;
                save=surplus;
                savei=i;
            }
            if (surplus<0){
                System.out.println("-1");
                System.exit(0);
            }
        }
        int oldsurplus=surplus;
        surplus=0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(')surplus++;
            if (s.charAt(i)==')')surplus--;
            if (s.charAt(i)=='#'){
                surplus--;
                if (i==savei){
                    surplus-=oldsurplus;
                }
            }
            if (surplus<0){
                System.out.println("-1");
                System.exit(0);
            }
        }
        for (int i=0; i<countones-1; i++){
            System.out.println(1);
        }
        System.out.println(1+oldsurplus);
    }
}