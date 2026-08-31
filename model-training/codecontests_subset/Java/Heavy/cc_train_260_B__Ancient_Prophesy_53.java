import java.io.*;
import java.util.*;
public class B260_Ancient_Prophesy {
    public static void main (String[]args)throws Exception{
        BufferedReader read = new BufferedReader(new InputStreamReader (System.in));
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        
            String[] days = new String [1500];
            String n = "";
            int l,c=0;
            for(int x=2013;x<=2015;x++){
                for(int m=1;m<=12;m++){
                    if(m > 9)
                        n = "-" + m + "-" + x;
                    else
                        n = "-0" + m + "-" + x;
                    switch(m){
                        case 1:case 3: case 5: case 7: case 8: case 10: case 12 :l=31;break;
                        case 2: l = 28;break;
                        default : l = 30;
                    }
                    for(int d=1;d<=l;d++)
                        if(d <= 9)
                            map.put("0" + d + n, 0);
                        else
                            map.put(d + n,0);
                    
                }
            }
        
        
        String in = read.readLine();
        String[] di = new String[100000];
        for(int i=0;i<=in.length()-10;i++)
            di[i] = in.substring(i,i+10);
        
        int max  = 0;
        String ans = "";
        for(int i=0;i<di.length;i++){
            if(map.get(di[i]) != null){
                map.put(di[i],map.get(di[i])+1);
                if(map.get(di[i]) > max){
                    max = map.get(di[i]);
                    ans = di[i];
                }
            }
        }
        
        System.out.println(ans); 
    }
}