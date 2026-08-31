import java.io.*;
import java.util.*;

public class cp {

    static class XD{
        int dur;
        int a;
        int b;

        public XD(int dur,int a,int b){
            this.dur=dur;
            this.a=a;
            this.b=b;
        }
    }
    static class Sorter implements Comparator<XD>{

        public int compare(XD o1,XD o2){
            int f=(o2.a+o2.b-o1.a-o1.b);
            if(f==0)
            return o2.a-o1.a;
            return f;
        }
    }

    static class Sorter2 implements Comparator<XD>{

        public int compare(XD o1,XD o2){
            return o1.dur-o2.dur;
        }
    }

    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder();
        // int t = Integer.parseInt(br.readLine());
        // while (t-- > 0) {
            // int n=Integer.parseInt(br.readLine());
            String[] lol = br.readLine().split(" ");
            int n = Integer.parseInt(lol[0]); long k = Long.parseLong(lol[1]);
            int alice=0,bob=0;
            ArrayList<XD> a=new ArrayList<>();
            for(int i=0;i<n;i++){
                lol=br.readLine().split(" ");
                if(lol[1].equals("1") || lol[2].equals("1"))
                a.add(new XD(Integer.parseInt(lol[0]),Integer.parseInt(lol[1]),Integer.parseInt(lol[2])));
                if(lol[1].equals("1"))
                alice++;
                if(lol[2].equals("1"))
                bob++;
            }
            if(alice<k || bob<k)
            str.append("-1\n");
            else{
                int sum=0;
                Collections.sort(a,new Sorter().thenComparing(new Sorter2()));            
                int i1=0,i2=-1,i3=-1;
                for(int i=0;i<a.size();i++){
                    XD f=a.get(i);
                    if(f.b==0 && f.a==1)
                    {
                        i2=i;
                        break;
                    }
                }  
                for(int i=0;i<a.size();i++){
                    XD f=a.get(i);
                    if(f.b==1 && f.a==0)
                    {
                        i3=i;
                        break;
                    }
                }
                if(i2==-1 || i3==-1){
                    for(int i=0;i<k;i++)
                    sum+=a.get(i).dur;
                }   
                else{
                    int c1=0,c2=i2,c3=i3;
                    while(k>0 && c1<i2 && c2 < i3 && c3 <a.size()){
                        if(a.get(c1).dur<a.get(c2).dur+a.get(c3).dur){
                            sum+=a.get(c1).dur;
                            c1++;
                            k--;
                        }
                        else{
                            sum+=a.get(c2).dur+a.get(c3).dur;
                            c2++;
                            c3++;
                            k--;
                        }
                    }
                        if(c2==i3 || c3==a.size()){
                            while(k>0){
                                sum+=a.get(c1).dur;
                                c1++;
                                k--;
                            }
                        }
                        if(c1==i2){
                            while(k>0){
                                sum+=a.get(c2).dur+a.get(c3).dur;
                                c2++;
                                c3++;
                                k--;
                            }
                        }
                    
                }
                str.append(sum+"\n");
            }            
        // }
        out.print(str);
        out.close();
    }

}