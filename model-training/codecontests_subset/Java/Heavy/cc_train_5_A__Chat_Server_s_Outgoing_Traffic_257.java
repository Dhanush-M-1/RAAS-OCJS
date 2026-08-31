import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		ArrayList<String> list=new ArrayList<String>();
		int sum=0;
		while((s=br.readLine())!=null){
			if(s.charAt(0)=='+'){
				s=s.substring(1);
				list.add(s);
			}else if(s.charAt(0)=='-'){
				s=s.substring(1);
				list.remove(s);
			}else{
				String[] ss=s.split(":");
				if(ss.length==2){
					StringBuffer sb=new StringBuffer(ss[1]);
					sum +=sb.length()*list.size();
				}
				
			}
		}
		System.out.println(sum);
	}

}

 	  	 			  						 	 					 			