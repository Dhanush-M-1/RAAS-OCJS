 

import java.io.*;

public class competetive {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
        int n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        boolean flag=false;
        boolean w=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                for(int j=1;i+j<n;j++){

                    int k=i+j;
                    boolean sub=false;
                    boolean s2=true;
                    int count=0;
                    while(k<n){
                        if(s.charAt(k)=='*'){
                            count++;
                            if(count==4&&s2){
                                sub=true;
                                break;
                            }
                        }else{
                            s2=false;
                        }
                        k+=j;
                    }
                    flag=sub;
                    if(flag&&!w){
                        out.write("yes");
                        w=true;
                        break;
                    }

                }
            }
        }
        if (!w){
            out.write("no"+'\n');
        }
        out.flush();
    }


}
