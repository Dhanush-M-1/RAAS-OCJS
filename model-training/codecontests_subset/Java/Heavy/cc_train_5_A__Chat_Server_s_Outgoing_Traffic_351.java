import java.util.Scanner;

/**
 *
 * @author FranciscoJavier
 */
public class Chatacm {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int part=0;
        long bytes=0;
        while(entrada.hasNext()){
            String cmd=entrada.nextLine();
            if(cmd.equals("0"))
                break;
            if(cmd.charAt(0)=='+'){
                part++;
            }
            else if(cmd.charAt(0)=='-'){
                part--;
            }
            else{
                String[] partes=cmd.split(":");
                if(partes.length>1){
                    cmd=partes[1];
                    bytes+=(cmd.length()*part);
                }
            }
        }
        System.out.print(bytes);
    }
    
}