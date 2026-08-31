#include <bits/stdc++.h>
const int N = 1000 + 10;
const int MAXN = 1e9 + 8;
using namespace std;
int n, m, q;
int l, r;
bool sign = false;
struct Node {
  int u, v, d, t;
} f[N * N / 2];
bool cmp(Node A, Node B) { return A.d > B.d; }
void init() {
  scanf("%d %d %d", &n, &m, &q);
  int u, v, d;
  for (int i = 1; i <= m; i++) {
    scanf("%d %d %d", &f[i].u, &f[i].v, &f[i].d);
    f[i].t = i;
  }
  sort(f + 1, f + m + 1, cmp);
}
int fa[N * 2];
int findx(int x) { return x == fa[x] ? x : fa[x] = findx(fa[x]); }
void solve() {
  for (int i = 1; i <= n * 2 + 1; i++) {
    fa[i] = i;
  }
  int u, v, lu, lv, ru, rv;
  for (int i = 1; i <= m; i++)
    if (f[i].t >= l && f[i].t <= r) {
      u = f[i].u, v = f[i].v;
      lu = (u << 1), lv = (v << 1), ru = (u << 1 | 1), rv = (v << 1 | 1);
      if (findx(lu) == findx(lv) || findx(ru) == findx(rv)) {
        printf("%d\n", f[i].d);
        return;
      }
      if (fa[lu] != fa[rv]) fa[fa[lu]] = fa[rv];
      if (fa[ru] != fa[lv]) fa[fa[ru]] = fa[lv];
    }
  printf("-1\n");
}
void work() {
  for (int i = 1; i <= q; i++) {
    cin >> l >> r;
    solve();
  }
}
int main() {
  init();
  work();
  return 0;
}
