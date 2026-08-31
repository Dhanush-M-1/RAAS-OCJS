#include <iostream>
#include <queue>
#include <cassert>
using namespace std;

int S[366][4][4] = {};
int vis[366][3][3][7][7][7][7] = {};
int dx[9] = {-1,0,1,0,-2,0,2,0,0},dy[9] = {0,-1,0,1,0,-2,0,2,0};

struct state{
    int x = 1,y = 1;
    int d = 1;
    int rest[4][4] = {};
    bool in(){
        return 0<=x && x<=2 && 0<=y && y<=2;
    }
    void update(){
        for(int i=0;i<4;i++) for(int j=0;j<4;j++) rest[i][j]++;
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) rest[x+i][y+j] = 0;
    }
    bool ok(){
        if(!in()) return false;
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) if(S[d][x+i][y+j]==1) return false;
        return true;
    }
    bool ok2(){
        for(int i=0;i<4;i++) for(int j=0;j<4;j++) if(rest[i][j]==7) return false;
        return true;
    }
};
int main(){
    int N;
    while(cin >> N && N){
        for(int d=1;d<=N;d++) for(int i=0;i<4;i++) for(int j=0;j<4;j++) cin >> S[d][i][j];
        for(int d=0;d<=N;d++) for(int i=0;i<3;i++) for(int j=0;j<3;j++) 
        for(int a=0;a<7;a++) for(int b=0;b<7;b++)
        for(int c=0;c<7;c++) for(int e=0;e<7;e++) vis[d][i][j][a][b][c][e] = 0;
        queue<state> Q;
        state init;
        init.update();
        if(!init.ok()){
            cout << 0 << endl;
            continue;
        }
        Q.push(init);
        int complete = 0;
        while(!Q.empty()){
            state now = Q.front(); Q.pop();
            if(now.d==N){
                complete = 1;
                break;
            } 
            for(int i=0;i<9;i++){
                state ne = now;
                ne.x += dx[i]; ne.y += dy[i];
                ne.d++;
                if(!ne.ok()) continue;
                ne.update();
                if(ne.ok2() && !vis[ne.d][ne.x][ne.y][ne.rest[0][0]][ne.rest[0][3]][ne.rest[3][0]][ne.rest[3][3]]){
                    vis[ne.d][ne.x][ne.y][ne.rest[0][0]][ne.rest[0][3]][ne.rest[3][0]][ne.rest[3][3]] = 1;
                    Q.push(ne);
                }
            }
        }
        cout << complete << endl;
    }
}
