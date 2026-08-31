#include <cstdio>
#include <algorithm>

using namespace std;
const int N = 2e5 + 5;
const int LogN = 23;
const long long inf = 1e17;

int A[N], n;
long long D;

struct Edge {
    int u, v;
    long long w;
} e[N * LogN];
int etot = 0;

void buildGraph(int l, int r) {
    if (l == r) return;
    int mid = (l + r) >> 1;
    buildGraph(l, mid);
    buildGraph(mid + 1, r);

    int x, y;
    long long f = inf, g = inf;

    for (int i = l; i <= mid; i++)
        if (f > A[i] - i * D)
            f = A[i] - i * D, x = i;
    for (int i = mid + 1; i <= r; i++)
        if (g > A[i] + i * D)
            g = A[i] + i * D, y = i;
    
    for (int i = mid + 1; i <= r; i++)
        e[++etot] = Edge{x, i, f + A[i] + i * D};
    for (int i = l; i <= mid; i++)
        e[++etot] = Edge{y, i, g + A[i] - i * D};
    return;
}

int fa[N];
int find(int x) {
    return x == fa[x] ? x : fa[x] = find(fa[x]);
}
void init_ufs(int n) {
    for (int i = 1; i <= n; i++)
        fa[i] = i;
}
bool merge(int u, int v) {
    int fu = find(u), fv = find(v);
    if (fu == fv) return false;
    return fa[fu] = fv, true;
}

long long Kruskal_MST() {
    sort(e + 1, e + 1 + etot, [](Edge& a, Edge& b) {
        return a.w < b.w;
    });
    init_ufs(n);

    long long ans = 0ll;
    for (int i = 1, c = 0; c < n - 1; i++)
        if (merge(e[i].u, e[i].v))
            ans += e[i].w, ++c;
    
    return ans;
}

signed main() {
    scanf("%d%lld", &n, &D);
    for (int i = 1; i <= n; i++)
        scanf("%d", A + i);
    
    buildGraph(1, n);
    printf("%lld\n", Kruskal_MST());
    return 0;
}