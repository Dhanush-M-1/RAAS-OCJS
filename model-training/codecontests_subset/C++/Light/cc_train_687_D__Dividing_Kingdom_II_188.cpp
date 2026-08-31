#include <bits/stdc++.h>
using namespace std;
int n, m, q, l, r, fa[1010 * 2];
struct ma {
  int u, v, c, num;
} e[1010 * 1010];
bool operator<(ma p, ma q) { return p.c > q.c; }
int find(int x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
void doit() {
  for (int i = 1; i <= n * 2; i++) fa[i] = i;
  scanf("%d%d", &l, &r);
  for (int i = 1; i <= m; i++)
    if (e[i].num >= l && e[i].num <= r) {
      int u = e[i].u, v = e[i].v;
      if (find(u) != find(v + n)) fa[find(u)] = find(v + n);
      if (find(v) != find(u + n)) fa[find(v)] = find(u + n);
      if (find(u) == find(u + n)) {
        printf("%d\n", e[i].c);
        return;
      }
    }
  puts("-1");
}
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++)
    scanf("%d%d%d", &e[i].u, &e[i].v, &e[i].c), e[i].num = i;
  sort(e + 1, e + m + 1);
  while (q--) doit();
}
