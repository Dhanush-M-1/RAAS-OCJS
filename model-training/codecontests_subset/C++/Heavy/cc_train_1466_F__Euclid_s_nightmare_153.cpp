#include <bits/stdc++.h>
#define endl '\n'
#define all(a) (a).begin(), (a).end()
#define len(a) (int) (a).size()
#define forn(i, n) for (int (i) = 0; (i) < (n); ++(i))
#define int long long
using namespace std;
void solve();
mt19937 rnd(2007);
signed main(){
#ifdef LOCAL
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#else
    mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
    swap(rng, rnd);
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    solve();
}

struct dsu{
    vector<int> p;

    dsu(int n){
        p.resize(n);
        forn (i, n) p[i] = i;
    }

    int get(int v){
        if (p[v] == v)
            return v;
        return p[v] = get(p[v]);
    }

    bool unite(int v, int u){
        v = get(v), u = get(u);
        p[v] = u;
        return v != u;
    }

};

const int mod = (int) 1e9 + 7;
void solve() {
    int m; cin >> m;
    int n; cin >> n;
    dsu ds(n + 1);
    vector<int> ans;
    forn (qwe, m){
        int k; cin >> k;
        if (k == 1){
            int v; cin >> v;
            if (ds.get(v) != ds.get(0)) {
                ds.unite(v, 0);
                ans.push_back(qwe + 1);
            }
        }
        else {
            int v, u; cin >> v >> u;
            if (ds.unite(v, u)){
                ans.push_back(qwe + 1);
            }
        }
    }
    int res = 1;
    forn (qwe, len(ans)){
        res *= 2;
        res %= mod;
    }
    cout << res << ' ' << len(ans) << endl;
    for (auto i : ans){
        cout << i << ' ';
    }
    cout << endl;
}