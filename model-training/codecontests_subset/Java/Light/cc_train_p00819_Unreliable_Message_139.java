import java.util.*;
public class Main{
    static Scanner kbd = new Scanner(System.in);
    public static void main(String[] args){
	while(kbd.hasNext()){
	    int n = kbd.nextInt();
	    while(n>0){
		solve();
		n--;
	    }
	}
    }

    static void solve(){
	String order = kbd.next();
	String message = kbd.next();
	String[] m = new String[message.length()];
	String[] os = new String[order.length()];

	int i;
	for(i=0; i<message.length(); i++){
	    m[i] = message.substring(i, i+1);
	}

	for(i=0; i<order.length(); i++){  
	    os[i] = order.substring(i, i+1);
	}

	for(i=os.length-1; i>=0; i--){
	    change(m, os[i]);
	    /*
	    for(int j=0; j<m.length; j++){
		System.out.print(m[j]);
	    }
	    System.out.println();
	    */
	}
	
	String ans = "";
	for(i=0; i<m.length; i++){
	    ans += m[i];
	}
	System.out.println(ans);
    }

    static void change(String[] m, String os){
	int i;
	//左ずらし
	//"J"がやらかす間違い、"C"の訂正に使える
	if(os.equals("C")){
	    String a = m[0];
	    for(i=0; i<m.length-1; i++){
		m[i] = m[i+1];
	    }
	    m[m.length-1] = a;
	}
	//右ずらし
	//"C"がやらかす間違い、"J"の訂正に使える
	else if(os.equals("J")){
	    String a = m[m.length-1];
	    for(i=m.length-1; i>0; i--){
		m[i] = m[i-1];
	    }
	    m[0] = a;
	}
	//半分入れ替え
	else if(os.equals("E")){
	    int middle = m.length/2;
	    String[] r = new String[middle];
	    String[] l = new String[middle];
	    if(m.length%2==1){
		for(i=0; i<middle; i++){
		    r[i] = m[i];
		    l[i] = m[middle+i+1];
		}
		for(i=0; i<middle; i++){
		    m[i] = l[i];
		    m[middle+i+1] = r[i];
		}
	    }
	    else{
		for(i=0; i<middle; i++){
		    r[i] = m[i];
		    l[i] = m[middle+i];
		}
		for(i=0; i<middle; i++){
		    m[i] = l[i];
		    m[middle+i] = r[i];
		}
	    }
	}
	//反転
	else if(os.equals("A")){
	    for(i=0; i<(m.length)/2; i++){
		String w = m[i];
		m[i] = m[m.length-i-1];
		m[m.length-i-1] = w;
	    }
	}
	//数字なら1足す
	//"P"がやらかす間違い、"M"の訂正に使える。
	else if(os.equals("M")){
	    for(i=0; i<m.length; i++){
		if(isN(m[i])){
		    int n = (Integer.parseInt(m[i])+1)%10;
		    m[i] = Integer.toString(n);
		}
	    }
	}
	//数字なら1引く
	//"M"がやらかす間違い、"P"の訂正に使える。
	else if(os.equals("P")){
	    for(i=0; i<m.length; i++){
		if(isN(m[i])){
		    int n = (Integer.parseInt(m[i])-1+10)%10;
		    m[i] = Integer.toString(n);
		}
	    }
	}
    }

    static boolean isN(String s){
	if(s.equals("1")) return true;
	else if(s.equals("2")) return true;
	else if(s.equals("3")) return true;
	else if(s.equals("4")) return true;
	else if(s.equals("5")) return true;
	else if(s.equals("6")) return true;
	else if(s.equals("7")) return true;
	else if(s.equals("8")) return true;
	else if(s.equals("9")) return true;
	else if(s.equals("0")) return true;
	else return false;
    }
}