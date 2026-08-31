import java.io.*;
import java.util.ArrayList;

class Main{

    static int N;
    static ArrayList<ArrayList<Integer>> shop = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> P = new ArrayList<>();
    static int[] a = new int[10];
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        ArrayList<Integer> sp = new ArrayList<>();
        for (int i=0;i<N;i++){
            str = br.readLine();
            sp.clear();
            for (String s:str.split(" ")){
                sp.add(Integer.parseInt(s));
            }
            shop.add((ArrayList<Integer>)sp.clone());
        }
        ArrayList<Integer> c = new ArrayList<>();
        for (int i=0;i<N;i++){
            str = br.readLine();
            c.clear();
            for (String s:str.split(" ")){
                c.add(Integer.parseInt(s));
            }
            P.add((ArrayList<Integer>)c.clone());
        }
        dfs(0);
        dfs(1);
        System.out.println(ans);
    }

    static void func(){
        int cnt = 0;
        for (int i:a){
            if (i==1){
                cnt++;
            }
        }
        if (cnt==0){
            return;
        }
        int score = 0;
        for (int i=0;i<N;i++){
            cnt = 0;
            for (int j=0;j<10;j++){
                if (a[j]==1 && shop.get(i).get(j)==1){
                    cnt++;
                }
            }
            score += P.get(i).get(cnt);
        }
        
        ans = Math.max(ans,score);
    }

    static void dfs(int pos){
        if (pos==10){
            func();
        } else {
            a[pos] = 0;
            dfs(pos+1);
            a[pos] = 1;
            dfs(pos+1);
        }
    }
}