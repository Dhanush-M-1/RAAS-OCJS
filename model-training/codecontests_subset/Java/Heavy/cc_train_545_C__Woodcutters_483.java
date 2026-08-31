import java.util.*;
import java.io.*;
public class WoodCutters{
    public static void main(String args[]){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try{
            int n=Integer.parseInt(br.readLine());
            String[] temp;
            Tree[] trees=new Tree[n];
            for (int i = 0; i < n; i++) {
                temp=br.readLine().trim().split(" ");
                trees[i]=new Tree(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
            }
            Arrays.sort(trees, (a,b)-> a.pos-b.pos);
            int count=1;
            trees[0].dir=0;
            for (int i = 1; i < n-1; i++) {
                int c,d;
                d=trees[i+1].pos;
                if(trees[i-1].dir==1)
                    c=trees[i-1].pos+trees[i-1].height;
                else  
                    c=trees[i-1].pos;
                if(trees[i].pos-trees[i].height > c){
                    trees[i].dir=0;
                    count++;
                }
                else if(trees[i].pos + trees[i].height < d){
                    trees[i].dir=1;
                    count++;
                }
                else{
                    continue;
                }
            }
            count++;
            if(n==1)
                System.out.println(1);
            else
                System.out.println(count);
            br.close();
        }
        catch(IOException e){}
    }
}
class Tree{
    int pos,height,dir;
    public Tree(int pos,int height){
        this.pos=pos;
        this.height=height;
        this.dir=-1;
    }
}