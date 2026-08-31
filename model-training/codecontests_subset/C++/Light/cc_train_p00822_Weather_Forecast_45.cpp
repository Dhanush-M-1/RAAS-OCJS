#include <cstdio>
const int MAXN = 366;

const int move[] = {0, 1, 2, -1, -2, 4, 8, -4, -8};
int Day;
int rain[MAXN+10][20];
int vis[MAXN][12][7][7][7][7], T;

int dfs(int D, int pos, int n1, int n4, int n13, int n16){
    if(pos==1) n1 = 0; //1  2  3  4
    if(pos==3) n4 = 0; //5  6  7  8
    if(pos==9) n13= 0; //9  10 11 12
    if(pos==11)n16= 0; //13 14 15 16
    if(n1>=7 || n4>=7 || n13>=7 || n16>=7) return 0;
    if(D==Day+1) return 1;
    if(rain[D][pos]) return 0;
    if(rain[D][pos+1]) return 0;
    if(rain[D][pos+4]) return 0;
    if(rain[D][pos+5]) return 0;
    if(vis[D][pos][n1][n4][n13][n16]==T) return 0;
    vis[D][pos][n1][n4][n13][n16] = T;
    for(int i=0;i<9;i++){
        int npos = pos + move[i];
        if(npos%4 != (pos%4)+(move[i]%4) )  continue;
        if(npos<1 || 11<npos || npos==4 || npos==8) continue;
        if(dfs(D+1, npos, n1+1, n4+1, n13+1, n16+1)) return 1;
    }
    return 0;
}

int main(){
    while(scanf("%d", &Day)){
        if(Day==0) break;
        for(int i=1;i<=Day;i++){
            for(int j=1;j<=16;j++){
                scanf("%d", &rain[i][j]);
            }
        }
        T++;
        printf("%d\n", dfs(1, 6, 1, 1, 1, 1));
    }
    return 0;
}