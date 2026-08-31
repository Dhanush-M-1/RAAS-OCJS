import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main{

    static class ChessBoardSquare
    {

        public int distance;
        public Long pred;
        public Long x;
        public Long y;

        ChessBoardSquare()
        {

        }

        ChessBoardSquare(int distance,Long pred,Long x,Long y)
        {

            this.distance=distance;
            this.pred=pred;
            this.x=x;
            this.y=y;

        }
    };

    static int bfs(Long s,Long d,HashMap<Long,ChessBoardSquare> board)
    {
        if(board.containsKey(d-1))
        {
            int pos[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 0 }, { -1, 1 }, { -1, -1 } };
            Queue<ChessBoardSquare> q = new ArrayDeque<>();
            Set<ChessBoardSquare> visited = new HashSet<>();
            ChessBoardSquare sourceBoard = board.get(s - 1);
            sourceBoard.distance = 0;
            sourceBoard.pred = -1l;
            q.add(sourceBoard);
            while (q.size() != 0)
            {
                ChessBoardSquare currentBoardSquare = q.remove();

                for (int i = 0; i < 8; i++)
                {
                    Long adjx = currentBoardSquare.x + pos[i][0];
                    Long adjy = currentBoardSquare.y + pos[i][1];
                    Long adjpos = adjy * 1000000000 + adjx;

                    if(board.containsKey(adjpos))
                    {
                        ChessBoardSquare adjBoard = board.get(adjpos);
                        if (!visited.contains(adjBoard)  && adjx >= 0 && adjx < 1000000000 && adjy >= 0 && adjy < 1000000000)
                        {
                            adjBoard.distance = currentBoardSquare.distance + 1;
                            adjBoard.pred = currentBoardSquare.y * 1000000000 + currentBoardSquare.x;
                            q.add(adjBoard);
                            visited.add(adjBoard);
                        }
                    }
                }

            }
            return board.get(d-1).distance;
        }
        return -1;

    }

    static long getPos(long x, long y)
    {
        return (y-1)*1000000000 + x-1;
    }

    public static void main(String args[])
    {
        long x1,y1,x2,y2;
        HashMap<Long, ChessBoardSquare> board = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        y1=sc.nextLong();
        x1=sc.nextLong();
        y2=sc.nextLong();
        x2=sc.nextLong();
        int n;
        n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            long row = sc.nextLong();
            long xstart = sc.nextLong();
            long xend = sc.nextLong();
            for(long j=xstart;j<=xend;j++)
            {
                Long pos=getPos(j,row);
                board.put(pos,new ChessBoardSquare(-1,-1l,j-1,row-1));
            }
        }

        System.out.println(bfs(getPos(x1,y1)+1,getPos(x2,y2)+1,board));
    }
}
