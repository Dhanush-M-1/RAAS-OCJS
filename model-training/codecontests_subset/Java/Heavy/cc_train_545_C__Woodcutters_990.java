
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan
 */
public class thirdProblemGreedy {

    static int whereFit(int[][] treeInfo,int currTree)
    {
        //System.out.println(treeInfo[currTree][0]+" "+treeInfo[currTree][1]+" "+treeInfo[currTree][2]);
        boolean canLeft=false,canRight=false;
        if((treeInfo[currTree-1][2]==1||treeInfo[currTree-1][2]==0)&&((treeInfo[currTree][0]-treeInfo[currTree][1])>treeInfo[currTree-1][0]))
            canLeft=true;
        if(treeInfo[currTree-1][2]==2&&((treeInfo[currTree][0]-treeInfo[currTree][1])>(treeInfo[currTree-1][0]+treeInfo[currTree-1][1])))
            canLeft=true;
        if(((treeInfo[currTree][0]+treeInfo[currTree][1])<treeInfo[currTree+1][0]))
            canRight=true;
        if(canLeft&&canRight)
            return 3;
        if(canLeft)
            return 1;
        if(canRight)
            return 2;
        return 0;
            
    }
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int trees=Reader.nextInt();
        int[][] treeInfo=new int[trees][3];
        for(int i=0;i<trees;i++)
        {
            treeInfo[i][0]=Reader.nextInt();
            treeInfo[i][1]=Reader.nextInt();
            treeInfo[i][2]=0;
        }
        
        treeInfo[0][2]=1;
        treeInfo[trees-1][2]=2;
        int treeCount=2;
        int whereFit=0;
        
        for(int i=1;i<trees-1;i++)
        {
            whereFit=whereFit(treeInfo,i);
            if(whereFit==1||whereFit==3)
            {
                treeInfo[i][2]=1;
                treeCount++;
            }
            if(whereFit==2)
            {
                treeInfo[i][2]=2;
                treeCount++;
            }
    }
    
        if(trees==1)
            treeCount=1;
        System.out.println(treeCount);
       // for(int i=0;i<trees;i++)
       //     System.out.print(treeInfo[i][2]+" ");
    
}
}


class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}