#include <bits/stdc++.h>
#define ll long long
#define pb push_back
#define mp make_pair
using namespace std;
const int maxn = 200100;
ll a[maxn], n, d;
ll f[maxn], g[maxn];

int getf(int l, int r) {
    ll minvalue = LLONG_MAX;
    int ind = 0;
    for(int i=l;i<=r;i++) {
        if(f[i] < minvalue) {
            minvalue = f[i];
            ind = i;
        }
    }
    return ind;
}

int getg(int l, int r) {
    ll minvalue = LLONG_MAX;
    int ind = 0;
    for(int i=l;i<=r;i++) {
        if(g[i] < minvalue) {
            minvalue = g[i];
            ind = i;
        }
    }
    return ind;
}

vector<pair<ll, pair<int,int> > > edges;

void solve(int l, int r) {
    if(l >= r) return;
    else {
        int mid = (l + r) / 2;
        int fi = getf(l, mid);
        int si = getg(mid+1, r);

        for(int i=l;i<=mid;i++) {
            edges.pb(mp(f[i] + g[si], mp(i, si)));
        }
        for(int i=mid+1;i<=r;i++) {
            edges.pb(mp(f[fi] + g[i], mp(fi, i)));
        }

        solve(l, mid);
        solve(mid+1, r);
    }
}
int uparent[maxn];
int usize[maxn];

int ufind(int x) {
    while(uparent[x] != x) {
        x = uparent[x];
    }
    return x;
}

void unite(int x, int y) {
    x = ufind(x);
    y = ufind(y);

    if(x == y) return;

    if(usize[x] > usize[y]) {
        uparent[y] = x;
        usize[x] += usize[y];
    }
    else {
        uparent[x] = y;
        usize[y] += usize[x];
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin>>n>>d;
    for(ll i=1LL;i<=n;i++) {
        cin>>a[i];
        f[i] = a[i] - 1LL * i * d;
        g[i] = a[i] + 1LL * i * d;
        uparent[i] = i;
        usize[i] = 1;
    }
    solve(1, n);
    sort(edges.begin(), edges.end());
    ll result = 0LL;
    int br = 0;
    for(auto i:edges) {
        int x = i.second.first;
        int y = i.second.second;
        if(x == y) continue;
        if(ufind(x) != ufind(y)) {
            unite(x, y);
            result += i.first;
            br++;
        }
    }
    cout<<result<<"\n";
    return 0;
}