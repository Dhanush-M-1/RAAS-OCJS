
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
   
    static BufferedReader in; 
    
    public static void main(String[] args) throws IOException{        
        File file = new File("input.txt");
        if( file.exists() ) in = new BufferedReader(new FileReader(file));
        else in = new BufferedReader(new InputStreamReader(System.in));
        
        int months[]={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String s=in.readLine(), cur, ans;
        HashMap<String, Integer> map=new HashMap<>();
        int day, month, year, times=0;
        String toks[];
        for(int i=0; i<=s.length()-10; i++){
            cur=s.substring(i, i+10);
            if( !cur.matches("[0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]") )
                continue;
            toks=cur.split("-");
            day=Integer.parseInt(toks[0]);
            month=Integer.parseInt(toks[1]);
            year=Integer.parseInt(toks[2]);
            if(year<2013 || year>2015 || month<1 || month>12 || day<1 || day>months[month])
                continue;
            if( map.containsKey(cur) ) map.put(cur, map.get(cur)+1);
            else map.put(cur, 1);            
        }
        ans="";
        for (String str : map.keySet()) {
            if(map.get(str)>times) {
                times=map.get(str);
                ans=str;
            }
        }
        System.out.println(ans);
    }
    
    static void out(Object ...o){ System.out.println(Arrays.deepToString(o)); }    
    
    static String[] readToks() throws IOException{
        return in.readLine().split("[ ]+");
    }
    
    static int readInt() throws IOException{
        return Integer.parseInt(in.readLine());
    }
    
    static long readLong() throws IOException{
        return Long.parseLong(in.readLine());
    }
       
    static int[] readNums(int n) throws IOException{
        int[] nums = new int[n];
	int idx = 0;
	String line = in.readLine().trim();
	for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
		if(c == ' ') idx++;
		else {
                    int d = c - '0';
                    nums[idx] = 10 * nums[idx] + d;
		}
	}
		
	return nums;
    }
	
    static int[] readNums() throws IOException {		
        int idx = 0, n = 0;		
        String line = in.readLine().trim();
	int i;
	for(i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == ' ') break;
            int d = c - '0';
            n = 10 * n + d;
        }
		
	int[] nums = new int[n];
	for(i = i + 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == ' ') idx++;
            else {
                int d = c - '0';
                nums[idx] = 10 * nums[idx] + d;
            }
        }
	return nums;
    }
}