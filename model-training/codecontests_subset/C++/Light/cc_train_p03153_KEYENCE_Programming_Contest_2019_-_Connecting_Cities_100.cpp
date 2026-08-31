#include<iostream>
#include<cstdio>
#include<cstring>
#include<vector>
#include<algorithm>
#define ll long long
#define rep(i, a, b) for(int i = a; i <= b; i++)
void read(int &x) {
    x = 0; int flag = 1; char ch = ' ';
    while(ch < '0' || ch > '9') { if(ch == '-') flag = -1; ch = getchar(); }
    while(ch >= '0' && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
    x *= flag;
}
void read(ll &x) {
    x = 0; int flag = 1; char ch = ' ';
    while(ch < '0' || ch > '9') { if(ch == '-') flag = -1; ch = getchar(); }
    while(ch >= '0' && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
    x *= flag;
}
using namespace std;
const int maxn = 200010;
struct Edge {
    int u, v;
    ll w;
    Edge(){}
    Edge(int a, int b, ll c) { u = a, v = b, w = c; }
    bool operator < (const Edge & a) const {
        return w < a.w;
    }
};
vector <Edge> edge;
int n, f[maxn];
ll d, a[maxn];

int find(int x) { return f[x] == x ? f[x] : f[x] = find(f[x]); }

void solve(int l, int r) {
    if(l == r) return;
    int mid = (l + r) >> 1, px = 0, py = 0;
    ll x = 1e9, y = 1e9;
    x *= maxn; y *= maxn;
    rep(i, l, mid)
        if(a[i] - i * d <= x) {
            x = a[i] - i * d;
            px = i;
        }
    rep(i, mid + 1, r)
        if(a[i] + i * d <= y) {
            y = a[i] + i * d;
            py = i;
        }
    rep(i, l, mid)
        edge.push_back(Edge(i, py, (py - i) * d + a[i] + a[py]));
    rep(i, mid + 1, r)
        edge.push_back(Edge(px, i, (i - px) * d + a[px] + a[i]));
    solve(l, mid);
    solve(mid + 1, r);
}

int main()
{
    read(n), read(d);
    rep(i, 1, n) read(a[i]);
    solve(1, n);
    sort(edge.begin(), edge.end());
    ll ans = 0;
    rep(i, 1, n) f[i] = i;
    rep(i, 0, edge.size() - 1) {
        int u = edge[i].u, v = edge[i].v;
        int root1 = find(u), root2 = find(v);
        if(root1 != root2) {
            f[root1] = root2;
            ans += edge[i].w;
        }
    }
    printf("%lld\n", ans);
    return 0;
}