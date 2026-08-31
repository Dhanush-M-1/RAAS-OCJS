#include <bits/stdc++.h>

#define all(x) (x).begin(),(x).end()

using namespace std;
using ll = long long;
using pii = pair<int, int>;
template<typename... T> void rd(T&... args) {((cin>>args), ...);}
template<typename... T> void wr(T... args) {((cout<<args<<" "), ...);cout<<endl;}

struct UF {
    vector<int> fa, sz;
    vector<bool> single;
    UF(int n) : fa(n), sz(n, 1), single(n) {
        iota(all(fa), 0);
    }

    int find(int x) {
        return fa[x]==x ? x : fa[x]=find(fa[x]);
    }

    bool join(int x, int y) {
        x=find(x), y=find(y);
        if (x==y) return false;
        if (single[x] && single[y]) return false;
        if (sz[x]>sz[y]) swap(x, y);
        fa[x]=y;
        sz[y]+=sz[x];
        single[y]=single[y] || single[x];
        return true;
    }
};

constexpr int mod=1e9+7;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    cin>>n>>m;
    UF uf(m);
    vector<int> s;
    for (int i=0; i<n; i++) {
        int k;
        cin>>k;
        if (k==1) {
            int x;
            cin>>x;
            x--;
            x=uf.find(x);
            if (!uf.single[x]) {
                uf.single[x]=true;
                s.push_back(i);
            }
        } else {
            int x, y;
            cin>>x>>y;
            x--, y--;
            if (uf.join(x, y)) {
                s.push_back(i);
            }
        }
    }

    ll ans=1;
    for (int i=0; i<(int)s.size(); i++) {
        ans=2*ans%mod;
    }
    cout<<ans<<' '<<s.size()<<'\n';
    for (auto x:s) cout<<x+1<<' ';
    return 0;
}

