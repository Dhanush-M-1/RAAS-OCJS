import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        // 5A
        String h;
        int l = 0;
        int alive = 0;
        while (in.hasNext()) {
            h = in.nextLine();
            if (h.charAt(0) == '+') {
                alive++;
            } else if (h.charAt(0) == '-') {
                alive--;
            } else {
                int idx = h.indexOf(':');
                int msg = ((int) h.length()) - idx - 1;
                l += (msg * alive);
            }
        }
        System.out.println(l);

		
		
	/*	
        // 445B
		int n = in.nextInt(), m = in.nextInt();
		int [] arr= new int[n+1];
		int ret = (int)Math.pow(2, n-1);
		for (int i = 1 ; i <=m ;i++){
			int e = in.nextInt(), g = in.nextInt();
			arr[e] = 1;
			arr[g] = 1;
		}
		int cou = 0;
		for (int i = 1 ; i <= n ; i++){
			if (arr[i] != 1)
				cou++;
		}
		for (int i = 0 ; i  < cou-1 ; i ++)
			ret/=2;
		
		System.out.println(ret);
		*/
		


		
		
		
		/*		
		//         	
	    string n; int k;
	    cin >> n >> k;
	    
	    for (int i = 0 ; i < n.size()-1 ; i++){
			if (n[i] < n[i+1] && k>0){
				char h = n[i];
				n[i] = n[i+1];
				n[i+1] = h;
				k--;
				for (int j = i ; j > 0 ; j--){
					if (n[j] > n[j-1] && k>0){
						char h = n[j];
						n[j] = n[j-1];
						n[j-1] = h;
						k--;
					}
				}
			}
			if (k==0)
				break;
		}
	    cout << n;*/
		
/*		 // 584C
		int n= in.nextInt(), m= in.nextInt();
		String s1 = in.next(), s2 = in.next();
		int same = 0;
		for (int i = 0 ; i < n ; i++){
			if (s1.charAt(i) == s2.charAt(i)){
				same++;
			}
		}
		
		if (same <= m ){
			System.out.println(-1);
			System.exit(0);
		}
*/
		
/*
		int w = in.nextInt(), h = in.nextInt(), n = in.nextInt();
		
		int arrw[] = new int[200001];
		int arrh[] = new int[200001];
		arrw[0]=1;
		arrh[0]=1;
		for (int i = 0 ; i < 4 ; i++){
			String dir = in.next();
			int num = in.nextInt();
			
			
			
			System.out.println(dir+"           "+num);
			
			
			
			if (dir.equals("H")){
				arrw[num] = 1;
			}else{
				arrh[num] = 1;
			}
			
			
			int maxw=-1231233,maxh=-1212121;
			int id = -1,idx=-1;
			for (int p = 0 ; p < 200001;p++){
				if (arrw[p]==1){
					if (id !=-1){
						maxw = Math.max(maxw, p-id);
					}
					id = p;
				}
				if (arrh[p]==1){
					if (idx !=-1){
						maxh = Math.max(maxh,p-idx);
					}
					idx = p;
				}
			}

			
			
			System.out.println(maxh * maxw);
		}
		
*/
		
		
		
		
/*
		// 614/B
		int n ;
		n = in.nextInt();
		BigInteger z = new BigInteger("10");
		String h = "";String ret = "";
		for (int j = 0 ;j < n ; j++){
			h += in.next();
			h+= " ";
		}
		

		Scanner im = new Scanner(h);
		int ind= 0;
		while(im.hasNext()){
			BigInteger g = new BigInteger(im.next());
			
			BigInteger y =z.pow(g.toString().length()-1);
			if (g.subtract(y).compareTo( BigInteger.ZERO ) == 1){
				System.out.print(g);
				String q = g.toString();
				for (int o = q.length()-1 ; o >=0 ; o--){
					if (q.charAt(o) == '0'){
						ind++;
					}
					if (q.charAt(o) != '0'){
						break;
					} 
				}
				break;
			}
		}
		im.close();

		
		int ones = 1;
		for (int i = h.length()-1 ; i>=0 ; i--){
			
			if (h.charAt(i) != '0'){
				ones=0;
			}
			if (h.charAt(i) == ' '){
				ones = 1;
			}
			if (h.charAt(i) == '0' && ones == 1 && i !=0 && h.charAt(i-1) != ' '){
				ret+='0';
			}
			if ( (h.charAt(i) == '0' && ones == 1 && i == 0) ||  (h.charAt(i) == '0' && ones == 1 && i != 0 && h.charAt(i-1) == ' ') ){
				System.out.println(0);
				in.close();
				System.exit(0);
			}

		}
System.out.println(ret.substring(0,ret.length()-ind));
*/


        in.close();
    }


}