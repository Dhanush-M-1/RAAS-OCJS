#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define dbg(x) cout <<#x<<":"<<x<<endl;
#define dbgpo(x, y) cout<<"("<<x<<", "<<y<<")";
#define fast ios_base::sync_with_stdio(false); cin.tie(NULL)
#define pb push_back
#define eb emplace_back
#define f first
#define s second
#define mp make_pair
#define pii pair<int, int>
#define pll pair<ll, ll>
#define endl '\n'
#define mod 1000000007
// #define int long long
#define vi vector<int>

inline int parent(vi &par,int i){
    while(i!=par[i]) {
        par[i] = par[par[i]];
        i = par[i];
    }
    return i;
}

inline void union1(vi &par, vi &sz,int p1, int p2) {
    if(sz[p1]<sz[p2]){
        par[p1] = p2;
        sz[p2] += sz[p1];
    }
    else {
        par[p2] = p1;
        sz[p1] += sz[p2];
    }
}


signed main() {
    fast;
    int n, dim;
    cin >> n >> dim;
    vector<int> par(dim+1), sz(dim+1,1);
    iota(par.begin(),par.end(),0);

    vector<int> ans;
    for(int i = 1; i <=n; ++i) {
        int k; cin >> k;
        int a,b;
        if(k==1)
            cin >> a,b=0;
        if(k==2)
            cin >> a >> b;
        a = parent(par,a);
        b = parent(par,b);
        if(a!=b) {
            ans.pb(i);
            union1(par,sz,a,b);
        }
    }

    vector<int> p2(dim+1);
    p2[0] = 1;
    for(int i=1;i<=dim;++i)
        p2[i] = (p2[i-1]<<1)%mod;


    ll ansVal = 1;
    for(int i=0;i<=dim;++i)
        if(par[i] == i) {
            ansVal *= ll(p2[sz[i]-1])%mod;
            ansVal %= mod;
        }

    cout << ansVal << ' ' << ans.size() << endl;    
    for(auto &x: ans)
        cout << x << ' ';
}
