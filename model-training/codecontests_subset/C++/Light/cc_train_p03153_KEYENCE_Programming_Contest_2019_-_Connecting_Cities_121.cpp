#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define N 200010
#define INFLL 0x3f3f3f3f3f3f3f3f
int n, m;
ll d, a[N];
struct Edge
{
    int u, v; ll w;
    Edge() {}
    Edge(int u, int v, ll w) : u(u), v(v), w(w) {}
    bool operator < (const Edge &other) const { return w < other.w; }
}edge[N * 30];

void add(int l, int r)
{
    if (l == r) return;
    int mid = (l + r) >> 1;
    ll Min = INFLL; int pos = -1; 
    for (int i = l; i <= mid; ++i) 
    {
        ll f = a[i] - d * i;
        if (f < Min)
        {
            Min = f;
            pos = i;
        }
    }
    for (int i = mid + 1; i <= r; ++i)
        edge[++m] = Edge(pos, i, a[pos] + a[i] + d * (i - pos));
    Min = INFLL; pos = -1;
    for (int i = mid + 1; i <= r; ++i)
    {
        ll f = a[i] + d * i;
        if (f < Min)
        {
            Min = f;
            pos = i;
        }
    }
    for (int i = l; i <= mid; ++i) 
        edge[++m] = Edge(pos, i, a[pos] + a[i] + d * (pos - i));
    add(l, mid);
    add(mid + 1, r);
}

int pre[N];
int find(int x) { return pre[x] == 0 ? x : pre[x] = find(pre[x]); }
ll Kruskal()
{
    memset(pre, 0, sizeof pre);
    sort(edge + 1, edge + 1 + m);
    int cnt = 1;
    ll res = 0;
    for (int i = 1; i <= m; ++i)
    {
        int u = edge[i].u, v = edge[i].v; ll w = edge[i].w;
        int fu = find(u), fv = find(v);
        if (fu == fv) continue;
        pre[fu] = fv;
        res += w;
        ++cnt;
        if (cnt == n) return res;
    }
    return res;
}

int main()
{
    while (scanf("%d%lld", &n, &d) != EOF)
    {
        m = 0;
        for (int i = 1; i <= n; ++i) scanf("%lld", a + i);
        add(1, n);
        printf("%lld\n", Kruskal());
    }
    return 0;
}