import java.util.*;
import java.io.*;
public class HelpVasilisaTheWise2 {
    static BufferedReader br;
    static int[] s;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            init();
            System.out.println(solve());
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	s = new int[6];
    	int index = 0;
    	for(int i = 0; i < 3; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		s[index++] = Integer.parseInt(st.nextToken());
    		s[index++] = Integer.parseInt(st.nextToken());
    	}
    }
    private static String solve() {
        String res = "";
        for(int i = 1; i <= 9; i++) {
        	for(int j = 1; j <= 9; j++) {
        		if(i == j)
        			continue;
        		for(int k = 1; k <= 9; k++) {
        			if(i == k || j == k)
        				continue;
        			for(int l = 1; l <= 9; l++) {
        				if(i == l || j == l || k == l)
        					continue;
        				if(i + j == s[0] && k + l == s[1] && i + k == s[2] && j + l == s[3] && i + l == s[4] && j + k == s[5]) {
        					res += i + " " + j + "\n" + k + " " + l;
        					break;
        				}
        			}
        			if(res.length() > 0)
        				break;
        		}
        		if(res.length() > 0)
    				break;
        	}
        	if(res.length() > 0)
				break;
        }
        if(res.length() == 0)
        	return "-1";
        return res;
    }
}