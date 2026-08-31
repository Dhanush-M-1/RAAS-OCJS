#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
int n, m, q;
struct EDGE {
  int s, e, v, idx;
  EDGE() {}
  EDGE(int s, int e, int v, int idx) : s(s), e(e), v(v), idx(idx) {}
  bool operator<(const EDGE &p) const { return v > p.v; }
} edge[2000000];
EDGE a[2000000];
int ai;
int u[3000];
int find(int x) { return u[x] == x ? x : u[x] = find(u[x]); }
int main() {
  int i, j, k, l;
  cin >> n >> m >> q;
  for (i = 0; i < m; i++) {
    int x, y, z;
    scanf("%d%d%d", &x, &y, &z), x--, y--;
    edge[i] = EDGE(x, y, z, i);
  }
  sort(edge, edge + m);
  for (i = 0; i < q; i++) {
    int x, y;
    scanf("%d%d", &x, &y), x--, y--;
    ai = 0;
    for (j = 0; j < n * 2; j++) u[j] = j;
    int ans = -1;
    for (j = 0; j < m; j++)
      if (edge[j].idx >= x && edge[j].idx <= y) {
        int x1 = find(edge[j].s * 2), y2 = find(edge[j].e * 2 + 1);
        if (x1 != y2) u[x1] = y2;
        int y1 = find(edge[j].e * 2), x2 = find(edge[j].s * 2 + 1);
        if (y1 != x2) u[y1] = x2;
        if (find(edge[j].s * 2) == find(edge[j].s * 2 + 1) ||
            find(edge[j].e * 2) == find(edge[j].e * 2 + 1)) {
          ans = edge[j].v;
          break;
        }
      }
    printf("%d\n", ans);
  }
  return 0;
}
