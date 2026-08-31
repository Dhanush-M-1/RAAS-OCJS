#include <bits/stdc++.h>
using namespace std;
#define rep(i, n) for(ll i = 0; i < n; i++)
#define rep2(i, x, n) for(int i = x; i <= n; i++)
#define rep3(i, x, n) for(int i = x; i >= n; i--)
#define elif else if
#define sp(x) fixed << setprecision(x)
#define pb push_back
#define eb emplace_back
#define all(x) x.begin(), x.end()
#define sz(x) (int)x.size()
using ll = long long;
using ld = long double;
using pii = pair<int, int>;
using pil = pair<int, ll>;
using pli = pair<ll, int>;
using pll = pair<ll, ll>;
const ll MOD = 1e9+7;
//const ll MOD = 998244353;
const int inf = (1<<30)-1;
const ll INF = (1LL<<60)-1;
const ld EPS = 1e-10;
template<typename T> bool chmax(T &x, const T &y) {return (x < y)? (x = y, true) : false;};
template<typename T> bool chmin(T &x, const T &y) {return (x > y)? (x = y, true) : false;};

struct edge{int to; ll cost;};

const int MAX_V = 4e5;
vector<edge> es[MAX_V];
vector<int> col(MAX_V, -1);
vector<ll> d(MAX_V, INF);

void add_edge(int from, int to, ll cost){
    es[from].eb((edge){to, cost});
    es[to].eb((edge){from, cost});
}

void dijkstra(int n){
    priority_queue<pli, vector<pli>, greater<pli> > que;
    rep(i, n){
        d[i] = 0, col[i] = i;
        que.push(pli(d[i], i));
    }
    while(!que.empty()){
        pli p = que.top();
        que.pop();
        int v = p.second;
        if(p.first > d[v]) continue;
        for(auto &e: es[v]){
            if(chmin(d[e.to], d[v]+e.cost)){
                col[e.to] = col[v];
                que.push(pli(d[e.to], e.to));
            }
        }
    }
}

int main(){
    int N; ll D;
    cin >> N >> D;
    ll A[N];
    rep(i, N){
        cin >> A[i];
        add_edge(i, N+i, A[i]);
    }
    rep(i, N-1) add_edge(N+i, N+i+1, D);
    dijkstra(N);
    ll ans = 0;
    rep(i, 2*N){
        for(auto &e: es[i]){
            int u = col[i], v = col[e.to];
            if(u < v){
                ans += A[u]+A[v]+D*abs(u-v);
            }
        }
    }
    cout << ans << endl;
}