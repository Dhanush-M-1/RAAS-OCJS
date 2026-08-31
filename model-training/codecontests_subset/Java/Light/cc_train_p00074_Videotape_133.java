
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
 

public class Main{
          
     
     public static void main(String args[]){
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         try{ String line;
             while((line=br.readLine())!=null){if(line.isEmpty())break;
             String spl[] = line.split(" ");
             int a= Integer.parseInt(spl[0]);
             int b= Integer.parseInt(spl[1]);
             int c= Integer.parseInt(spl[2]); if(a==-1&&b==-1&&c==-1)break;
             int all = 120*60;
             int tukatta = a*60*60+b*60+c;
             
             int nokori = all-tukatta;
             for(int i=0; i<2;i++){
                 if(i==1){nokori=nokori*3;}
             int nokoriFun = nokori/60; int nokoriByou=nokori%60;
             String top= (nokoriFun/60==0)? "00": "0"+(nokoriFun/60);
             nokoriFun=nokoriFun%60;
             String mid = (nokoriFun==0)? "00" :( nokoriFun/10==0)? "0"+nokoriFun: nokoriFun+"";
             String las = (nokoriByou/10==0)? "0"+nokoriByou : nokoriByou+"";
                 System.out.println(top+":"+mid+":"+las);
             }
                 
                 
             } br.close();
         }catch(Exception e){e.printStackTrace();}         
     }  
    
     
}
 