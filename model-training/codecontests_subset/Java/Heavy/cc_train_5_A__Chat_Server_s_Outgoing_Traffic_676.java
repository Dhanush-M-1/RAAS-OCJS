import java.util.*;
import java.math.*;

public class chatserver {
    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        int ans = 0;
        int peps = 0;
        while(br.hasNextLine()){
        	String line = br.nextLine();
        	if(line.charAt(0) == '+' || line.charAt(0) == '-'){
        		if(line.charAt(0) == '+'){
        			peps++;
        		}
        		else{
        			peps--;
        		}
        		continue;
        	}

        	StringTokenizer st = new StringTokenizer(line, ":");
        	st.nextToken();
        	if(st.hasMoreTokens()){
        		String message = st.nextToken();
        		ans+=message.length()*peps;
        	}
        }
        System.out.println(ans);
    }
}