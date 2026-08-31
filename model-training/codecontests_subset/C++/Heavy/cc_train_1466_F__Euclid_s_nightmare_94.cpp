#include <bits/stdc++.h>

//define/typeDef
#define all(a) a.begin(), a.end()
#define double long double
#define int long long
#define NIL 0
#define INF LLONG_MAX
#define loop(n) for(int i=0;i<n; i++)
#define rloop(n) for(int i=n-1; i>=0; i--)
using namespace std;
const int mod = 1e9 + 7;
const int N = 5e5 + 50;
int par[N], sze[N];


int getParent(int node) {
    while (par[node] != node) {
        par[node] = par[par[node]];
        node = par[node];
    }
    return node;
}

bool makeUnion(pair<int, int> edge) {
    int u = edge.first;
    int v = edge.second;

    u = getParent(u);
    v = getParent(v);

    if (u == v)
        return false;

    if (sze[u] < sze[v])
        swap(u, v);

    sze[u] += sze[v];
    par[v] = par[u];
    return true;


}

signed main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    int m;
    cin >> m;

    vector<pair<int, int> > edges;

    for (int i = 0; i < n; i++) {
        int cnt;
        cin >> cnt;

        int u, v = m + 1;
        cin >> u;

        if (cnt > 1)
            cin >> v;

        edges.emplace_back(u, v);
    }

    int mst = 1;
    for (int i = 1; i <= m + 1; i++) {
        par[i] = i, sze[i] = 1;
    }
    vector<int> ans;
    int cnt = 0;
    for (auto edge: edges) {
        if (makeUnion(edge)) {
            mst = (mst * 2) % mod;
            ans.push_back(++cnt);
        } else {
            ++cnt;
        }
    }

    cout << mst << ' ';
    cout<<ans.size()<<'\n';


    for(auto x: ans){
        cout<<x<<' ';
    }



}


