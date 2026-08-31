import java.util.*;
public class TwoGram{
	public static void main(String []args){
		
		java.util.Scanner scan=new java.util.Scanner(System.in);
		int n=scan.nextInt();
		String str=scan.next();
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		int count=1;
		for(int i=1;i<str.length();i++){
			String s=str.charAt(i-1)+""+str.charAt(i);
			if(map.containsKey(s)){
				count=map.get(s);
				count++;
				map.replace(s,count);
			}else{
				map.put(s,1);
			}
		}
		String strFinal="";int countMax=0;
		Iterator hmIterator = map.entrySet().iterator(); 
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            count = (int)mapElement.getValue();
			if(count>countMax){
				countMax=count;
				strFinal=(String)mapElement.getKey();
			}
        } 	
		System.out.println(strFinal);
	}
}