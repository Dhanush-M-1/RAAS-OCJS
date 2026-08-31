
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class cls5_ChatServersOutgoingTraffic {
    
    int SenderCount = 0;
    int bytCount = 0;
    
    public static void main(String[] args) throws Exception {
        
        cls5_ChatServersOutgoingTraffic cls = new cls5_ChatServersOutgoingTraffic();

        //BufferedReader br = new BufferedReader(new FileReader("Resources/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
	    String line = br.readLine();
	    if (line == null) {
		break;
	    }
	    cls.Calc(line);
	}

        br.close();
        
        System.out.println(cls.bytCount);
    }
    
    private void Calc(String line)
    {
        if(line.startsWith("+"))
            SenderCount++;
        else if(line.startsWith("-"))
            SenderCount--;
        else
        {
            String[] arr = line.split(":");
            int MessageLength = arr.length == 1 ? 0 : arr[1].length();

            bytCount = bytCount + (MessageLength * SenderCount);
        }
    }
}
