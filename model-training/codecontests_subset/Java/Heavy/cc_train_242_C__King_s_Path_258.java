import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class d {
    static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
    ;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String[] s1 = s();
        int x0=i(s1[0]);int y0=i(s1[1]);int x1=i(s1[2]);int y1=i(s1[3]);
        String[] s2=s();
        int m=i(s2[0]);
        HashMap<Integer,HashMap<Integer,Integer>> allowed=new HashMap<>();
        for(int i=0;i<m;i++){
            String[] s3=s();
            int r=i(s3[0]);int c1=i(s3[1]);int c2=i(s3[2]);
            for(int j=c1;j<=c2;j++){
                if(!allowed.containsKey(r)){
                    HashMap<Integer,Integer> h=new HashMap<>();
                    h.put(c1,1);
                    allowed.put(r,h);
                }else{
                    HashMap<Integer,Integer> h=allowed.get(r);
                    h.put(j,h.getOrDefault(j,0)+1);
                    allowed.put(r,h);
                }
            }
        }fans=0;
        HashMap<Integer,HashMap<Integer,Integer>> vis=new HashMap<>();
        bfs(allowed,vis,x0,y0,x1,y1,0);
        if(fans==0) System.out.println(-1);else
        System.out.println(fans);
    }static int fans;
    static void bfs(HashMap<Integer,HashMap<Integer,Integer>>allowed,HashMap<Integer,HashMap<Integer,Integer>>vis,int x,int y,int x1,int y1,int ans){
        Queue<Integer> qx=new LinkedList<>();
        Queue<Integer> qy=new LinkedList<>();
        qx.add(x);qy.add(y);

        HashMap<Integer,Integer> h1=new HashMap<>();
        h1.put(y,0);
        vis.put(x,h1);
        while(!qx.isEmpty()){
        x=qx.poll();y=qy.poll();

        if(x==x1&&y==y1) {
            fans=vis.get(x).get(y);return;
        }
   //     System.out.println(x+" "+y);
    //        System.out.println(vis.get(x).get(y));
   /*     if(!vis.containsKey(x)){
            HashMap<Integer,Integer> h=new HashMap<>();
            h.put(y,1);
            vis.put(x,h);
        }
        else{
            HashMap<Integer,Integer> h=vis.get(x);
            h.put(y,h.getOrDefault(y,0)+1);
            vis.put(x,h);
        }*/
        int x2=x;int y2=y;
        x2-=0;y2-=1;
        if(y2>=1&&allowed.containsKey(x2)&&allowed.get(x2).containsKey(y2)){
            if(!vis.containsKey(x2)||!vis.get(x2).containsKey(y2)){
               qx.add(x2);qy.add(y2);
                HashMap<Integer,Integer> h;
                if(!vis.containsKey(x2))
                    h=new HashMap<>();
                else
                    h=vis.get(x2);
               h.put(y2,vis.get(x).get(y)+1);
               vis.put(x2,h);

            //    bfs(allowed,vis,x2,y2,x1,y1,ans+1);
            }
        }x2=x;y2=y;
        x2-=1;y2-=1;
        if(y2>=1&&x2>=1&&allowed.containsKey(x2)&&allowed.get(x2).containsKey(y2)){
            if(!vis.containsKey(x2)||!vis.get(x2).containsKey(y2)){
                qx.add(x2);qy.add(y2);
                HashMap<Integer,Integer> h;
                if(!vis.containsKey(x2))
                    h=new HashMap<>();
                else
                    h=vis.get(x2);
                h.put(y2,vis.get(x).get(y)+1);
                vis.put(x2,h);

                //     bfs(allowed,vis,x2,y2,x1,y1,ans+1);
            }
        }x2=x;y2=y;  x2-=1;y2-=0;
        if(x2>=1&&allowed.containsKey(x2)&&allowed.get(x2).containsKey(y2)){
            if(!vis.containsKey(x2)||!vis.get(x2).containsKey(y2)){
                qx.add(x2);qy.add(y2);
                HashMap<Integer,Integer> h;
                if(!vis.containsKey(x2))
                h=new HashMap<>();
                else
                    h=vis.get(x2);
                h.put(y2,vis.get(x).get(y)+1);
                vis.put(x2,h);

                //       bfs(allowed,vis,x2,y2,x1,y1,ans+1);
            }
        }x2=x;y2=y;  x2-=1;y2+=1;
        if(x2>=1&&y2<=1000000000&&allowed.containsKey(x2)&&allowed.get(x2).containsKey(y2)){
            if(!vis.containsKey(x2)||!vis.get(x2).containsKey(y2)){
                qx.add(x2);qy.add(y2);
                HashMap<Integer,Integer> h;
                if(!vis.containsKey(x2))
                    h=new HashMap<>();
                else
                    h=vis.get(x2);

                h.put(y2,vis.get(x).get(y)+1);
                vis.put(x2,h);

                //      bfs(allowed,vis,x2,y2,x1,y1,ans+1);
            }
        }x2=x;y2=y;  x2-=0;y2+=1;
        if(y2<=1000000000&&allowed.containsKey(x2)&&allowed.get(x2).containsKey(y2)){
            if(!vis.containsKey(x2)||!vis.get(x2).containsKey(y2)){
                qx.add(x2);qy.add(y2);
                HashMap<Integer,Integer> h;
                if(!vis.containsKey(x2))
                    h=new HashMap<>();
                else
                    h=vis.get(x2);

                h.put(y2,vis.get(x).get(y)+1);
                vis.put(x2,h);

                //      bfs(allowed,vis,x2,y2,x1,y1,ans+1);
            }
        }x2=x;y2=y;  x2+=1;y2+=1;
        if(y2<=1000000000&&x2<=1000000000&&allowed.containsKey(x2)&&allowed.get(x2).containsKey(y2)){
            if(!vis.containsKey(x2)||!vis.get(x2).containsKey(y2)){
                qx.add(x2);qy.add(y2);
                HashMap<Integer,Integer> h;
                if(!vis.containsKey(x2))
                    h=new HashMap<>();
                else
                    h=vis.get(x2);

                h.put(y2,vis.get(x).get(y)+1);
                vis.put(x2,h);

                //    bfs(allowed,vis,x2,y2,x1,y1,ans+1);
            }
        }x2=x;y2=y;
        x2+=1;y2+=0;
        if(y2<=1000000000&&x2<=1000000000&&allowed.containsKey(x2)&&allowed.get(x2).containsKey(y2)){
            if(!vis.containsKey(x2)||!vis.get(x2).containsKey(y2)){
                qx.add(x2);qy.add(y2);
                HashMap<Integer,Integer> h;
                if(!vis.containsKey(x2))
                    h=new HashMap<>();
                else
                    h=vis.get(x2);

                h.put(y2,vis.get(x).get(y)+1);
                vis.put(x2,h);

                //       bfs(allowed,vis,x2,y2,x1,y1,ans+1);
            }
        }x2=x;y2=y;x2+=1;y2-=1;
        if(y2>=1&&x2<=1000000000&&allowed.containsKey(x2)&&allowed.get(x2).containsKey(y2)){
            if(!vis.containsKey(x2)||!vis.get(x2).containsKey(y2)){
                qx.add(x2);qy.add(y2);
                HashMap<Integer,Integer> h;
                if(!vis.containsKey(x2))
                    h=new HashMap<>();
                else
                    h=vis.get(x2);

                h.put(y2,vis.get(x).get(y)+1);
                vis.put(x2,h);

                //              bfs(allowed,vis,x2,y2,x1,y1,ans+1);
            }
        }x2=x;y2=y;
    }}
    static String[] s() throws IOException {
        return s.readLine().trim().split("\\s+");
    }

    static int i(String ss) {
        return Integer.parseInt(ss);
    }

    static long l(String ss) {
        return Long.parseLong(ss);
    }
    static long[] fac ;static int MAXN;
    static void calculatefac(long mod){
        fac[0]=1;
        for (int i = 1 ;i <= MAXN; i++)
            fac[i] = fac[i-1] * i % mod;
    }
    static long modInverse(long a, long m)
    {
        return (powerwithmod(a, m - 2, m));
    }
    static long powerwithmod(long  x, long y, long p) {
        long  res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}