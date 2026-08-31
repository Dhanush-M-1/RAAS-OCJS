import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Piet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstLine = sc.nextLine().split(" ");
        int totHeight = Integer.parseInt(firstLine[0].trim());
        int totWidth = -1;
        int n = Integer.parseInt(firstLine[1].trim());
        int[][] board = null;
        for (int r = 0; r < totHeight; r++) {
            String row = sc.nextLine();
            if(board == null) {
                board = new int[totHeight][row.length()];
                totWidth = row.length();
            }
            for (int c = 0; c < totWidth; c++) {
                board[r][c] = row.charAt(c);
            }
        }
        boolean[][] covered = new boolean[totHeight][totWidth];
        for (int i = 0; i < covered.length; i++) {
            Arrays.fill(covered[i], false);
        }
        ArrayList<Rect> rects = new ArrayList<Rect>();
        Rect first = null;
        for (int r = 0; r < totHeight; r++) {
            for (int c = 0; c < totWidth; c++) {
                if(!covered[r][c]) {
                    int val = board[r][c];
                    int width = 0;
                    int height = 0;
                    for (int i = c; i < totWidth; i++) {
                        if(board[r][i] == val) {
                            width++;
                        } else {
                            break;
                        }
                    }
                    for (int i = r; i < totHeight; i++) {
                        if(board[i][c] == val) {
                            height++;
                        } else {
                            break;
                        }
                    }
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            covered[r+i][c+j] = true;
                        }
                    }
                    Rect rect = new Rect(val, r,  c, width, height);
                    if(first == null) {
                        first = rect;
                    }
                    rects.add(rect);
                }
            }
        }
        
        for (int i = 0; i < rects.size(); i++) {
            Rect r = rects.get(i);
            
            // 0: R l
            r.nexts[0] = findRect(board, r.x0, r.y0+r.width, rects);
            
            // 1: R r
            r.nexts[1] = findRect(board, r.x0+r.height-1, r.y0+r.width, rects);
            
            // 2: B l
            r.nexts[2] = findRect(board, r.x0+r.height, r.y0+r.width-1, rects);
            
            // 3: B r
            r.nexts[3] = findRect(board, r.x0+r.height, r.y0, rects);

            // 4: L l
            r.nexts[4] = findRect(board, r.x0+r.height-1, r.y0-1, rects);
            
            // 5: L r
            r.nexts[5] = findRect(board, r.x0, r.y0-1, rects);
            
            // 6: B l
            r.nexts[6] = findRect(board, r.x0-1, r.y0, rects);
            
            // 7: B r
            r.nexts[7] = findRect(board, r.x0-1, r.y0+r.width-1, rects);
        }
        
        int dp = 0;
        boolean cLeft = true;
        Rect rect = first;
        
        for (int i = 0; i < n; i++) {
            Rect next = rect.nexts[2*dp+(cLeft?0:1)];
            if(next != null) {
                rect = next;
            } else {
                if(cLeft) {
                    cLeft = false;
                } else {
                    cLeft = true;
                    dp = (dp+1)%4;
                }
            }
        }
        System.out.println(rect.color);
    }

    private static HashMap<String, Rect> cache = new HashMap<String, Rect>();
    private static Rect findRect(int[][] board, int x, int y, ArrayList<Rect> rects) {
        String key = "("+x+","+y+")";
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        try {
            if(board[x][y] == '0') {
                cache.put(key, null);
                return null;
            }
            for(Rect r : rects) {
                if(r.isInside(x, y)) {
                    cache.put(key, r);
                    return r;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        cache.put(key, null);
        return null;
    }
}

class Rect {
    int x0, y0, width, height;
    int color;
    Rect[] nexts = new Rect[8];
    
    public Rect(int color, int x0, int y0, int width, int height) {
        this.color = color-'0';
        this.x0 = x0;
        this.y0 = y0;
        this.width = width;
        this.height = height;
    }
    
    public boolean isInside(int x, int y) {
        boolean xFit = x0 <= x && x < x0+height;
        boolean yFit = y0 <= y && y < y0+width;
        return xFit && yFit;
    }
    
    public String toString() {
        return "("+x0+","+y0+")"+width+"x"+height;
    }
}
