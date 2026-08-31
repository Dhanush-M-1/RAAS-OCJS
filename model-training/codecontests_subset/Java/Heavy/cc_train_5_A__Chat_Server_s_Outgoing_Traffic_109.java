import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line;
        int participants = 0, traffic = 0;
        
        while(in.hasNext()) {
            line = in.nextLine();
            if(line.charAt(0) == '+') participants++;
            else if(line.charAt(0) == '-') participants = Math.max(0, --participants);
            else {
                int index = line.indexOf(':');
                String msg = line.substring(index+1);
                
                traffic += msg.length() * participants;
            }
        }
        
        System.out.println(traffic);
    }
    
}