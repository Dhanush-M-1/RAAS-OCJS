import java.util.*;
import java.lang.*;
import java.io.*;
public class dates{
    public static void main(String args[])throws IOException{
        new dates().solve();
    }
    public void solve() throws IOException{
        Map<String,Integer> map=new HashMap<String,Integer>();
        Scanner in=new Scanner(System.in);     
        String s=in.nextLine();
        int i,j;
        for(i=0;i<=s.length()-10;i++){
            String temp=s.substring(i,i+10);
         if(isDate(temp)){
             if(!map.containsKey(temp)){
                 map.put(temp, 1);
                 
             }else{
                 map.put(temp, map.get(temp)+1);
             }
         }
        }
        String ans="";
        int max=Integer.MIN_VALUE;
        
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                ans=entry.getKey();
            }
           
        }
       System.out.println(ans);
        
        
    }
    public boolean isDate(String date) {
        if(date.charAt(2)!='-'||date.charAt(5)!='-'){
        return false;
         
        }
        else{int iday;
        int imon;
        int iyr;
            String day=date.substring(0,2);
            String mon=date.substring(3,5);
            String yr=date.substring(6,10); 
            if(Character.isDigit(day.charAt(0))&&Character.isDigit(day.charAt(1)))
            {iday=Integer.parseInt(day);}
            else 
                return false;
             if(Character.isDigit(mon.charAt(0))&&Character.isDigit(mon.charAt(1)))
            imon=Integer.parseInt(mon);
             else return false;
            if(Character.isDigit(yr.charAt(0))&&Character.isDigit(yr.charAt(1))&&Character.isDigit(yr.charAt(2))&&Character.isDigit(yr.charAt(3)))
           iyr=Integer.parseInt(yr);
            else return false;
            if(iyr<2016&&iyr>2012){
                if(imon>0&&imon<13){
                    if(imon==2){
                        if(iday<=28&&iday>0){
                            return true;
                            
                        }
                        else 
                            return false;
                    }
                    else if(imon==1||imon==3||imon==5||imon==7||imon==8||imon==10||imon==12){
                        if(iday<=31&&iday>0)
                            return true;
                        else 
                            return false;
                    }
                    else{
                        if(iday<=30&&iday>0)
                            return true;
                        else 
                            return false;
                    }
                }
                else return false;
            }
            else return false;
        }
        
    }
}
