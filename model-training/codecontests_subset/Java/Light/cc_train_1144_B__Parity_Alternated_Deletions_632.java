import java.util.*;
import java.util.Arrays;
 import java.util.ArrayList;
 
public class siri{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		 
		int pasuxi = 0; 
		 
		int zoma = sc.nextInt();
		ArrayList<Integer> knt = new ArrayList<Integer>();
		ArrayList<Integer> luw = new ArrayList<Integer>();
		
		for(int j = 0; j < zoma; j++){
		    int wevri = sc.nextInt();
		    if(wevri % 2 == 0){
		        luw.add(wevri);
		    }
		    else{
		        knt.add(wevri);
		    }
		}
		
		
		Collections.sort(knt);
		Collections.sort(luw);
		
		if(luw.size() >= knt.size() ){
		    for(int i = 0; i<luw.size()-1-knt.size();i++){
		        pasuxi += luw.get(i);
		    }
		}
		else{
		    for(int i = 0; i<knt.size()-1-luw.size();i++){
		        pasuxi += knt.get(i);
		    }
		}
		System.out.println(pasuxi);
		
	}
}