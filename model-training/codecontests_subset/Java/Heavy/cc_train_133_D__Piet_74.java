import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CF133D {

    //static State[][][] memo; //[blockIndex][DP][CP]
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt() + 2;
        int n = sc.nextInt();
        int[][] pixels = null; //yx
        int mw = 0;
        for (int i = 0; i < m - 2; i++) {
            String s = sc.next();
            if(mw == 0) {
                mw = s.length() + 2;
                pixels = new int[m][mw];
            }
            for (int j = 0; j < mw - 2; j++) {
                pixels[i+1][j+1] = s.charAt(j) - '0';
            }
        }
        Block[][] blocks = new Block[m][mw];
        Block dummy = new Block(-1, -1, 0, -1, -1, -1);
        for (Block[] blocks2 : blocks) {
            Arrays.fill(blocks2, dummy);
        }
        boolean[][] visited = new boolean[m][mw];
        List<Block> blocksList = new ArrayList<Block>(Math.max(m*mw/4, 8));
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < mw - 1; j++) {
                int c = pixels[i][j];
                if (c != 0 && !visited[i][j]) {
                    int width = 1;
                    int height = 1;
                    int j2 = j;
                    int i2 = i;
                    while(pixels[i][j2+1] == c) {
                        width++;
                        j2++;
                    }
                    while(pixels[i2+1][j] == c) {
                        height++;
                        i2++;
                    }
                    Block block = new Block(j, i, c, width, height, blocksList.size());
                    blocksList.add(block);
                    for (int k = i; k <= i2; k++) {
                        for (int k2 = j; k2 <= j2; k2++) {
                            blocks[k][k2] = block;
                            visited[k][k2] = true;
                        }
                    }
                    j = j2;
                }
            }
        }
        for (Block block : blocksList) {
            //cp == left
            block.nexts[LEFT] = blocks[block.y + block.height - 1][block.x - 1];
            block.nexts[UP] = blocks[block.y - 1][block.x];
            block.nexts[RIGHT] = blocks[block.y][block.x + block.width];
            block.nexts[DOWN] = blocks[block.y + block.height][block.x + block.width - 1];
            //cp == right
            block.nexts[LEFT + 4] = blocks[block.y][block.x - 1];
            block.nexts[UP + 4] = blocks[block.y - 1][block.x + block.width - 1];
            block.nexts[RIGHT + 4] = blocks[block.y + block.height - 1][block.x + block.width];
            block.nexts[DOWN + 4] = blocks[block.y + block.height][block.x];
        }
        
        Block bp = blocksList.get(0);
        int dp = RIGHT;
        int cp = LEFT;
        for (int i = 0; i < n; i++) {
            Block nextBlock = bp.nexts[dp + (cp == LEFT ? 0 : 4)];
            if (nextBlock != dummy) {
                bp = nextBlock;
            }
            else if (cp == LEFT){
                cp = RIGHT;
            }
            else {
                cp = LEFT;
                dp = dp == LEFT ? UP
                        : dp == UP ? RIGHT
                                : dp == RIGHT ? DOWN
                                        : LEFT;
            }
        }
        System.out.println(bp.c);
    }
    
    static class Block {
        final int x; 
        final int y;
        final int c;        
        final int width;
        final int height;
        final int index;
//        int nextLU;
//        int nextLD;
//        int nextRU;
//        int nextRD;
//        int nextUL;
//        int nextUR;
//        int nextDL;
//        int nextDR;
        final Block[] nexts = new Block[8]; 
        public Block(int x, int y, int c, int width, int height, int index) {
            super();
            this.x = x;
            this.y = y;
            this.c = c;
            this.width = width;
            this.height = height;
            this.index = index;
        }
        
        
    }
    final static int LEFT = 0;
    final static int RIGHT = 1;
    final static int UP = 2;
    final static int DOWN = 3;
    
    static class State {
        final int bp;
        final int dp;
        final int cp;
        public State(int bp, int dp, int cp) {
            super();
            this.bp = bp;
            this.dp = dp;
            this.cp = cp;
        }
        
    }

}
