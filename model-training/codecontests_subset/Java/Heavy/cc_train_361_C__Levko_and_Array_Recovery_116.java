import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class RestoreArray {
    public static void main(String[] args) throws IOException{
    	BufferedReader reader = null;
    	try {
    		reader = new BufferedReader(new InputStreamReader(System.in));
    		String [] str = reader.readLine().split(" ");
    		int n = Integer.parseInt(str[0]);
    		int m = Integer.parseInt(str[1]);
    		long[] a = new long[n];
    		long[] max = new long[n];
    		String[] s = new String[m];
    		Arrays.fill(a, 0);
    		Arrays.fill(max, Long.MAX_VALUE);
    		for(int i=0;i<m;i++){
        		s[i] = reader.readLine();
        		str = s[i].split(" ");
        		int t = Integer.parseInt(str[0]);
        		int l = Integer.parseInt(str[1])-1;
        		int r = Integer.parseInt(str[2])-1;
        		long d = Long.parseLong(str[3]);
        		if(t==1){
        			for(int j=l;j<=r;j++){
        				a[j]+=d;
        			}
        		}else{
        			for(int j=l;j<=r;j++){
        				if(max[j] > d - a[j])
        					max[j] = d - a[j];
        			}
        		}
    		}
			for(int j=0;j<n;j++){
				if(max[j] > Integer.MAX_VALUE){
					max[j] = 0;
				}
				a[j] = max[j];
			}
			boolean bPossible = true;
    		for(int i=0;i<m;i++){
        		str = s[i].split(" ");
        		int t = Integer.parseInt(str[0]);
        		int l = Integer.parseInt(str[1])-1;
        		int r = Integer.parseInt(str[2])-1;
        		long d = Long.parseLong(str[3]);
        		if(t==1){
        			for(int j=l;j<=r;j++){
        				a[j]+=d;
        			}
        		}else{
        			boolean bGood = false;
        			for(int j=l;j<=r;j++){
        				if(a[j] == d){
        					bGood = true;
        				}
        			}
        			if(!bGood){
        				bPossible = false;
        				break;
        			}
        		}
    		}
    		if(bPossible){
    			System.out.println("YES");
    			for(int j=0;j<n;j++){
    				System.out.print(max[j] + " ");
    			}
    			System.out.println();
    		}else{
    			System.out.println("NO");
    		}
		} finally {
			if(reader != null)
			reader.close();
		}
    }
}
