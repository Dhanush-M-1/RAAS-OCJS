import java.util.*;
public class B284 {
    public static void main(String[] args){
        Scanner br = new Scanner(System.in);
        int n = br.nextInt();
        String line = br.next();
        int icount = 0;
        int acount = 0;
        for(int i = 0;i<line.length();i++){
            if(line.charAt(i) == 'I'){
                icount++;
            }
            else if(line.charAt(i) == 'A'){
                acount++;
            }
        }
        if(icount > 1){
            System.out.println(0);
        }
        else if(icount == 1){
            System.out.println(icount);
        }
        else{
            System.out.println(acount);
        }
    }
}
