import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Test {

    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] split = br.readLine().split(" ");
        int bookcount = Integer.valueOf(split[0]);
        int genrecount = Integer.valueOf(split[1]);
        
        split = br.readLine().split(" ");
        
        int[] genres = new int[genrecount];
        for(int i=0; i<genrecount; i++)
            genres[i] = 0;
        
        int i;
        for(String s:split){
            i = Integer.valueOf(s);
            genres[i-1]++;
        }
        
        int result = 0;
        
        for(i=0; i<genrecount-1; i++)
            for(int j=i+1; j<genrecount; j++)
                result += genres[i] * genres[j];
        
        
        System.out.println(result);
    }
}