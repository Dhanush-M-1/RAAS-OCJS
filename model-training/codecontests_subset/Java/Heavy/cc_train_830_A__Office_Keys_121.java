
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author tamil-4501
 */
public class A_OfficeKeys {
    
    public static void main(String []a) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        String split[] = line.split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        long office = Long.parseLong(split[2]);
        long people[] = new long[n];
        long keys[] = new long[k];
        
        split = in.readLine().split(" ");
        for(int i=0; i<n; i++){
            people[i] = Long.parseLong(split[i]);
        }
        split = in.readLine().split(" ");
        for(int i=0; i<k; i++){
            keys[i] = Long.parseLong(split[i]);
        }
        Arrays.sort(people);
        Arrays.sort(keys);
        
        Long finalRes = Long.MAX_VALUE;
        for(int i=0; i<keys.length; i++){
            int index = i;
            long res = Long.MIN_VALUE;
            int went =0;
            boolean takenKey[] = new boolean[keys.length];
            while(went != people.length){
                if(index == keys.length){
                    //index = 0;
                    index = Math.abs(i - (keys.length - went));
                }

                if(!takenKey[index]){
                    long val1= Math.abs(people[went] - keys[index]);
                    long val2 = Math.abs(keys[index] - office);
                    long dist = Math.abs(val1 + val2);
                    //System.err.println("dist: "+dist+", val1: "+val1+", val2: "+val2);
                    res = Math.max(dist, res);
                    takenKey[index] = true;
                    went++;
                }
                index++;
            }
            finalRes = Math.min(res, finalRes);
        }
        System.out.println(finalRes);
    }
    
}