#include <bits/stdc++.h>
using namespace std;
int n, m, q;
struct data {
  int x, y, z, id;
  bool friend operator<(data a, data b) { return a.z > b.z; }
} w[500005];
int F[1005 << 1];
int Find(int a) {
  if (F[a] == a) return a;
  return F[a] = Find(F[a]);
}
void con(int a, int b) { F[Find(a)] = Find(b); }
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d%d", &w[i].x, &w[i].y, &w[i].z);
    w[i].id = i;
  }
  sort(w + 1, w + 1 + m);
  while (q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= (n << 1); ++i) F[i] = i;
    bool ok = 0;
    for (int i = 1; i <= m; ++i) {
      if (w[i].id < l || w[i].id > r) continue;
      int u = w[i].x, v = w[i].y, w = ::w[i].z;
      if (Find(u) == Find(v)) {
        ok = 1;
        printf("%d\n", w);
        break;
      } else {
        con(u, v + n);
        con(v, u + n);
        if (Find(u) == Find(u + n) || Find(v) == Find(v + n)) {
          ok = 1;
          printf("%d\n", w);
          break;
        }
      }
    }
    if (!ok) puts("-1");
  }
  return 0;
}
