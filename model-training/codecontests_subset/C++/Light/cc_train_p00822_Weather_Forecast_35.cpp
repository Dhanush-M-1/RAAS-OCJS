#include <bits/stdc++.h>
#define For(i, a, b) for(int (i)=(int)(a); (i)<(int)(b); ++(i))
#define rFor(i, a, b) for(int (i)=(int)(a)-1; (i)>=(int)(b); --(i))
#define rep(i, n) For(i, 0, n)
#define rrep(i, n) rFor(i, n, 0)
#define fi first
#define se second
using namespace std;
typedef long long lint;
typedef unsigned long long ulint;
typedef pair<int, int> pii;
typedef pair<lint, lint> pll;
template<class T> bool chmax(T &a, const T &b){if(a<b){a=b; return true;} return false;}
template<class T> bool chmin(T &a, const T &b){if(a>b){a=b; return true;} return false;}
template<class T> T div_floor(T a, T b){
    if(b < 0) a *= -1, b *= -1;
    return a>=0 ? a/b : (a+1)/b-1;
}
template<class T> T div_ceil(T a, T b){
    if(b < 0) a *= -1, b *= -1;
    return a>0 ? (a-1)/b+1 : a/b;
}

constexpr lint mod = 1000000007;
constexpr lint INF = mod * mod;
constexpr int MAX = 100010;

set<pair<pii, array<int, 4>>> S;
int n, a[370][4][4];
int dx[9] = {0, 0, 1, 0, -1, 0, 2, 0, -2};
int dy[9] = {0, 1, 0, -1, 0, 2, 0, -2, 0};

bool dfs(int cur, int pos, array<int, 4> rain){
    if(cur == n){
        //printf("%d (%d, %d)\n", cur, pos / 4, pos % 4);
        return true;
    }
    if(S.find({{cur, pos}, rain}) != S.end()) return false;

    int x = pos / 4, y = pos % 4;
    rep(i, 2)rep(j, 2){
        int nx = x + i, ny = y + j;
        if(a[cur][nx][ny]){
            S.insert({{cur, pos}, rain});
            return false;
        }
    }

    array<int, 4> nxt_rain;
    rep(i, 4) nxt_rain[i] = rain[i];
    if(pos == 0) nxt_rain[0] = -1;
    if(pos == 2) nxt_rain[1] = -1;
    if(pos == 8) nxt_rain[2] = -1;
    if(pos == 10) nxt_rain[3] = -1;
    rep(i, 4){
        ++nxt_rain[i];
        if(nxt_rain[i] == 7){
            S.insert({{cur, pos}, rain});
            return false;
        }
    }

    rep(i, 9){
        int nx = x + dx[i], ny = y + dy[i];
        if(0 <= nx && nx < 3 && 0 <= ny && ny < 3){
            if(dfs(cur + 1, nx * 4 + ny, nxt_rain)){
                //printf("%d (%d, %d)\n", cur, pos / 4, pos % 4);
                return true;
            }
        }
    }
    S.insert({{cur, pos}, rain});
    return false;
}

int main(){
    while(scanf("%d", &n) && n){
        S.clear();
        rep(i, n)rep(x, 4)rep(y, 4) scanf("%d", &a[i][x][y]);
        printf("%d\n", dfs(0, 5, {0, 0, 0, 0}));
    }
}
