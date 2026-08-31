#include<bits/stdc++.h>
#define ll long long
#define pb push_back
#define lowbit(x) ((x)&(-(x)))
#define mid ((l+r)>>1)
#define lson rt<<1, l, mid
#define rson rt<<1|1, mid+1, r
#define fors(i, a, b) for(int i = (a); i < (b); ++i)
using namespace std;
const int maxn = 3e4 + 5;
ll dp[maxn][5];
int p[maxn];
int n, c, q,idx;
int cmp(int x, int y){return p[idx+x] < p[idx+y];}
vector<int> s[maxn];
ll L[maxn][5], R[maxn][5];
ll SL[maxn][5];
void init(){
    scanf("%d%d%d", &n, &c, &q);
    fors(i,1,n+1) scanf("%d", &p[i]);
    p[0] = -1;
    fors(i,0,c+1) dp[n+1][i] = 1;
    for(int i = n; i > 0; --i){
        s[i].clear();
        for(int j = 0; j <= c; ++j){
            if(i+j <= n) s[i].pb(j);
            dp[i][j] = 0;
            for(int k = 0; k <= j && i+k <= n; ++k) dp[i][j] += dp[i+k+1][j-k];
        }idx = i;
        sort(s[i].begin(), s[i].end(),cmp);
    }
    for(int i = 1; i <= n; ++i){
        for(int j = 0; j <= c; ++j){
            ll sum = 0;
            for(int x: s[i]){
                if(x > j) continue;
                if(x == 0) break;
                sum += dp[i+x+1][j-x];
            }
            L[i][j] = sum;
            R[i][j] = sum + dp[i+1][j];
        }
    }
    fors(i,1,n+1) fors(j,0,c+1) SL[i][j] = SL[i-1][j] + L[i][j];
}
int work(int pos, ll rk){
    if(rk > dp[1][c]) return 0;
    int cur = c;
    for(int i = 1; i <= n; ++i){
        if(i > pos) return pos;
        if(rk > L[i][cur] && rk <= R[i][cur]){
            int l = i, r = n;
            int res = -1;
            ll del = SL[i-1][cur];
            while(l <= r){
                if(SL[mid][cur]-del >= rk || SL[mid-1][cur]-del+R[mid][cur] < rk){
                    r = mid-1;
                }else{
                    res = mid; l = mid+1;
                }
            }
            rk -= SL[res][cur]-del;
            i = res;
        }else{
            for(int x:s[i]){
                if(x > cur) continue;
                if(rk > dp[i+x+1][cur-x]) rk -= dp[i+x+1][cur-x];
                else{
                    cur -= x;
                    if(pos <= i+x && pos >= i){
                        pos = i+x+i-pos;
                    }
                    i += x;
                    break;
                }
            }
        }
    }
    return pos;
}
void sol(){
    while(q--){
        int pos; ll rk;
        scanf("%d%lld", &pos, &rk);
        int cur = c;
        printf("%d\n", p[work(pos, rk)]);
    }
}
int main()
{
    int T;cin>>T;
    while(T--){
        init();
        sol();
    }
	return 0;
}
/*
1
6 4 4
6 5 4 3 1 2
1 1
3 14
1 59
2 6
*/
