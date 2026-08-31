#include<bits/stdc++.h>
using namespace std;

#define FOR(a, b, c) for(int a = b; a <= c; ++a)
#define fi first
#define se second
#define pb push_back
#define int long long

typedef pair<int, int> ii;
typedef pair<int, ii> iii;

const int N = 2e5 + 10;
const int oo = 1e18;

int n, D, ans = 0;
int A[N], val[N], pr[N];
vector<iii> edge;

int nfind(int u)     { return (pr[u] == u) ? u : (pr[u] = nfind(pr[u])); }

void addeg(int u, int v)    {
    if(nfind(u) == nfind(v)) return;
    ans += D * abs(u - v) + A[u] + A[v];
    pr[nfind(u)] = nfind(v);
}

void solve(int lef, int rig)    {
    if(lef >= rig) return;

    int mid = (lef + rig) / 2;
    ii minl = {oo, 0}, minr = {oo, 0};
    FOR(i, lef, mid)    {
        val[i] = A[i] - i * D;
        minl = min(minl, {val[i], i});
    }
    FOR(i, mid + 1, rig) {
        val[i] = A[i] + i * D;
        minr = min(minr, {val[i], i});
    }
    FOR(i, lef, mid) edge.pb({val[i] + minr.fi, {i, minr.se}});
    FOR(i, mid + 1, rig) edge.pb({val[i] + minl.fi, {i, minl.se}});

    solve(lef, mid); solve(mid + 1, rig);
}
signed main()  {
//    freopen("test.inp", "r", stdin);
//    freopen("test.out", "w", stdout);
    ios_base::sync_with_stdio(false); cout.tie(0);

    cin >> n >> D;
    FOR(i, 1, n) pr[i] = i;
    FOR(i, 1, n) cin >> A[i];

    solve(1, n);

    sort(edge.begin(), edge.end());

    for(auto i: edge)   addeg(i.se.fi, i.se.se);

    return cout << ans, 0;
}
