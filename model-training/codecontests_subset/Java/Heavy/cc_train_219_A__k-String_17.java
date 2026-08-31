import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
public class coin
{
    static String s,s1="";
    static int len;
    static int subsize;
    static char[] c;
    public static void main(String[] args)throws Exception 
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        subsize=Integer.parseInt(br.readLine());
        int x=-1;
        s=br.readLine();
        len=s.length();
        if((len%subsize)==0){
             c=s.toCharArray();
            Arrays.sort(c);
            if(check()){
                for(int i=subsize;--i>=0;)
                System.out.print(s1);
            }
            else{
                System.out.println(x);
            }
            
        }
        else{
           System.out.println(x);
        }
    }
    private static boolean check(){
        int i=0;
            while(i<len){
                int counter=0,y=0;
                for(int j=i;j<len;j++){
                    if(c[i]==c[j]){
                        counter++;
                    }
                    else{
                        if((counter%subsize)!=0){
                            return false;
                        }
                        else
                            for(int k=counter/subsize;--k>=0;)
                            s1=s1+String.valueOf(c[i]);
                            i=j;
                            y=-1;
                            counter=0;
                            break;
                        }
                    }
                    
                    if(((counter%subsize)==0) && (y==0)){
                        for(int k=counter/subsize;--k>=0;)
                        s1=s1+ String.valueOf(c[i]);
                        break;
                }
            }
            return true;
    }
}
