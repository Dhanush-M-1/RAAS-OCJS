#include <bits/stdc++.h>
#define pb          emplace_back
#define ll          long long
#define fi          first
#define se          second
#define mp          make_pair
#define int         int64_t

using namespace std;

typedef pair<int, int> pii;
const int N = int(2e5 + 7);
const int inf = int(1e18);

struct TEdge {
    int u, v, w;
    TEdge() {}
    TEdge(int u, int v, int w): u(u), v(v), w(w) {}
    bool operator < (const TEdge& o) const& {
        return w < o.w;
    }
};
int n, d, x, res, lab[N], f[N], g[N];
vector<TEdge> e;

int Find(int x) {return lab[x] < 0? x: lab[x] = Find(lab[x]);}
void Union(int r, int s) {
    if(lab[r] > lab[s]) swap(r, s);
    lab[r] += lab[s], lab[s] = r;
}

void Divide(int l, int r) {
    if(l == r) return;
    int mid = (l + r) >> 1, wf = inf, vf, wg = inf, vg;
    for(int i = l; i <= mid; ++i)
        if(wf > f[i]) wf = f[i], vf = i;
    for(int i = mid + 1; i <= r; ++i) {
        if(wg > g[i]) wg = g[i], vg = i;
        e.pb(vf, i, wf + g[i]);
    }
    for(int i = l; i <= mid; ++i) e.pb(vg, i, wg + f[i]);
    Divide(l, mid), Divide(mid + 1, r);
}

int32_t main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    #define Task        "test"
    if(fopen(Task".inp", "r")) {
        freopen(Task".inp", "r", stdin);
        freopen(Task".out", "w", stdout);
    }
    cin >> n >> d;
    for(int i = 1; i <= n; ++i) {
        cin >> x;
        f[i] = x - d * i;
        g[i] = x + d * i;
    }
    Divide(1, n);
    sort(e.begin(), e.end());
    memset(&lab, -1, sizeof lab);
    for(TEdge& ed: e) {
        int r = Find(ed.u), s = Find(ed.v);
        if(r != s) res += ed.w, Union(r, s);
    }
    cout << res;
}
