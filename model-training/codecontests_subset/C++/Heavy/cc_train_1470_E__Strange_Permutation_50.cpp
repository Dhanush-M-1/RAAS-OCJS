#pragma GCC optimize("Ofast","unroll-loops","omit-frame-pointer","inline")
#pragma GCC option("arch=native","tune=native","no-zero-upper")
#pragma GCC target("avx2")
#include <bits/stdc++.h>
using namespace std;
#define INF 2147483647
#define infL (1LL<<60)
#define inf (1<<30)
#define inf9 (1000000000)
#define MOD 1000000007//998244353//1000000007
#define EPS 1e-9
#define Gr 9.8
#define PI acos(-1)
#define REP(i,n) for(int (i)=0;(i)<(int)(n);(i)++)
#define REQ(i,n) for(int (i)=1;(i)<=(int)(n);(i)++)
#define lch (rt<<1)
#define rch (rt<<1|1)
#define readmp(n) for(int i=0,u,v;i<n;i++) {scanf("%d%d",&u,&v); mp[u].push_back(v); mp[v].push_back(u);}
typedef  long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef long double ld;
typedef unsigned int uint;
typedef unsigned long long ull;
typedef ld ValType;
template<typename  T> void maxtt(T& t1, T t2) {
    t1=max(t1,t2);
}
template<typename  T> void mintt(T& t1, T t2) {
    t1=min(t1,t2);
}
#define MAX (30135)

bool debug = 0;
int n,m,k;
int dx[4] = {0,1,0,-1}, dy[4] = {1,0,-1,0};
string direc="RDLU";
const ll MOD2 = (ll)MOD * (ll)MOD;
ll ln, lk, lm;
void etp(bool f = 0) {
    puts(f ?"YES" : "NO");
    exit(0);
}
void addmod(int &x, int y, int mod = MOD){
    x+=y; if (x>=mod) x-=mod;
    if(x<0) x+=mod;
    assert(x>=0 && x<mod);
}
void et(int x=-1) {
    printf("%d\n", x); exit(0);
}
ll fastPow(ll x, ll y, int mod=MOD) {
    ll ans = 1;
    while(y>0) {
        if(y&1) ans = (x * ans)%mod;
        x = x*x%mod;
        y>>=1;
    }
    return ans;
}
ll gcd1(ll x, ll y) {
    return y?gcd1(y,x%y):x;
}







struct mb {
    int sz=0;
    pii A[5];
}G[5][MAX];
ll fa[5][MAX];
ll I = 1e18+5;
tuple<int,int,ll> lg[5][15][MAX];
void fmain(int tid) {
    int c,q;
    scanf("%d%d%d", &n, &c, &q);
    vector<int> P(n);
    REP(i,n) {
        scanf("%d", &P[i]); P[i]--;
    }
    REP(i,c+1) REP(j,n) G[i][j].sz=0;
    REP(i,c+1) REP(j,n) {
        for(int k=0;k<=i;k++) {
            if(j+k+1>n) break;
            G[i][j].A[G[i][j].sz++]={i-k, j+k+1};
        }
        sort(G[i][j].A, G[i][j].A+G[i][j].sz, [&](pii a, pii b) {
            return P[a.second-1] < P[b.second-1];
        });
    }
    REP(i,c+1) fa[i][n]=1;
    REP(i,c+1) for(int j=n-1;j>=0;j--) {
        fa[i][j]=0;
        REP(z, G[i][j].sz) {
            int a,x; tie(a,x)=G[i][j].A[z];
            fa[i][j]+=fa[a][x]; mintt(fa[i][j], I);
        }
    }
    REP(i,c+1) {
        REP(k,15) lg[i][k][n]={-1,-1,I};
    }
    REP(i,c+1) REP(j,n) {
        ll cur=0;
        REP(z, G[i][j].sz) {
            int a,x; tie(a,x)=G[i][j].A[z];
            if (a==i) {
                lg[i][0][j]={a,x,cur}; break;
            }
            cur += fa[a][x]; mintt(cur, I);
        }
    }
    REQ(k,14) REP(i,c+1) REP(j,n) if(lg[i][k-1][j] != make_tuple(-1,-1,I)){
        int a,x; ll z; tie(a,x,z)=lg[i][k-1][j];
        int b,y; ll w; tie(b,y,w)=lg[a][k-1][x];
        lg[i][k][j] = {b,y,min(z+w,I)}; assert(a==i);
    } else lg[i][k][j] = {-1,-1,I};
    
    REQ(tt,q) {
        int i; ll j; scanf("%d%lld", &i,&j);
        i--;j--;
        int a=c, x=0;
        if (j>=fa[a][x]) {
            puts("-1"); continue;
        }
        vector<pii> vp;
        while (1) {
            for(int k=14;k>=0;k--) {
                int b,y; ll w; tie(b,y,w)=lg[a][k][x];
                if (w <=j && j-w < fa[b][y]) {
                    a=b;x=y; j-=w;
                }
            }
            if (x==n) break;
            REP(z, G[a][x].sz) {
                int b,y; tie(b,y)=G[a][x].A[z];
                if (fa[b][y] <= j) {
                    j-=fa[b][y];
                } else {
                    vp.push_back({x,y});
                    a=b;x=y;
                    break;
                }
            }
        }
        for(auto &p : vp) reverse(begin(P)+p.first, begin(P)+p.second);
        printf("%d\n", P[i]+1);
        for(auto &p : vp) reverse(begin(P)+p.first, begin(P)+p.second);
    }
}
int main() {
    int t=1;
//    init();
    scanf("%d", &t);
//    init();
    REQ(i,t) {
        fmain(i);
    }
    return 0;
}
