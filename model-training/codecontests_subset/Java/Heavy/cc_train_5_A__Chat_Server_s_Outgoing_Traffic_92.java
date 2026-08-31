
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OutgoingTraffic {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int size = 0;
        int traffic = 0;
        while ((line = br.readLine())!=null) {
            if (line.charAt(0) == '+') {
                size++;
            } else if (line.charAt(0) == '-') {
                size--;
            } else {
                int index=0;
                while(line.charAt(index)!=':') index++;
                traffic += size*line.substring(index+1).length();
            }
        }
        System.out.println(traffic);
    }
}