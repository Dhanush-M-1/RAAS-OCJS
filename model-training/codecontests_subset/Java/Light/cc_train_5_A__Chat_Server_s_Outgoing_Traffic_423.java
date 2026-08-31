import java.util.*;
public class CodeForces5A{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int online=0;
        int result=0;
        while(input.hasNext()){
            String s = input.nextLine();

            if(s.charAt(0)=='+') online++;
            else if(s.charAt(0)=='-') online--;
            else{
                int n = s.indexOf(":");
                String mes = s.substring(n+1);
                result+=online*mes.length();}}
        input.close();
        System.out.println(""+result);}}