import java.util.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// 入力
		int n = sc.nextInt();
		
		// 計算
		Permutation perm = new Permutation(n);
		
		// 出力
		for(String r : perm.list){
		    System.out.println(r);
		}
		//char result = 'a' + 3;
		//System.out.println(result);
	}
}

class Permutation {
    int n;
    ArrayList<String> list;
    long cnt = 0;
    
    public Permutation(int n){
        this.n = n;
        ArrayList<String> list = new ArrayList<String>();
        dfs("", 1, list);
        this.list = list;
    }
    
    private void dfs(String s, int max, ArrayList<String> list){
        this.cnt++;
        if(s.length() == n){
            list.add(s);
            return;
        }
        for(int i = 0; i < max; i++){
            char c = (char)('a' + i);
            //System.out.println("i:" + i + " now:" + now + " char:" + c);
            if(i == max-1){
                dfs(s + c, max+1, list);
            }else{
                dfs(s + c, max, list);
            }
        }
    }
}


