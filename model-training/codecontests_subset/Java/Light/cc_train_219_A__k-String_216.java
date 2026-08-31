import java.util.*;
public class Main {
    public static void reset(int [] v){
        for(int i='a';i<='z';i++)v[i]=0;
    } 
    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        while(read.hasNext()){
            int n=Integer.parseInt(read.nextLine());
            String str=read.nextLine();
            int [] v=new int[255];
            reset(v);
            for(int i=0;i<str.length();i++){
                v[str.charAt(i)]++;
            }
            boolean flag=true;
            String ans="";
            for(int i='a';i<='z';i++){
                if(v[i]!=0&&v[i]%n!=0){flag=false;break;}
                else if(v[i]>0){
                    int aux=v[i]/n;
                    for(int j=0;j<aux;j++)ans=ans+(char)i;
                }
            }
            if(flag){for(int k=0;k<n;k++){System.out.print(ans);}System.out.println();}
            else System.out.println(-1);
        }
    }   
}
