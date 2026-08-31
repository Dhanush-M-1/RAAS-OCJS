import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeSet;


public class Mafia {
    public static void main(String[] Args) throws IOException{
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in)); 
            
        int num=Integer.parseInt(in.readLine());
        String[] val = in.readLine().split(" ");
        PriorityQueue<Integer> set = new PriorityQueue<Integer>();
        int max=0;
        int times=0;
        for(int i=0; i< num;++i){
            int play=Integer.parseInt(val[i]);
            set.add(play);
            if(max<play){
                max=play;
            }
        }
        while(max>times){
            int del=max-times;
            int play=set.poll();
            if(max==play){
                while(del>=num){
                    times+=num;
                    del-=num-1;
                }
                if(del>0)++del;
                times+=del;
                break;
            }else{
                int t=max-play;
                if (del<t)
                    t=del;
                times+=t;
            }
        }
        System.out.print(times);
    }
}
