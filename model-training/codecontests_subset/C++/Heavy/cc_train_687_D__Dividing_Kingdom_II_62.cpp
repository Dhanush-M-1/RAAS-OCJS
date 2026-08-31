#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T &x) {
  x = 0;
  char c = getchar();
  bool p = 0;
  for (; c < '0' || c > '9'; c = getchar())
    if (c == '-') p = 1;
  for (; c >= '0' && c <= '9'; c = getchar())
    x = (x << 3) + (x << 1) + (c ^ 48);
  if (p) x = -x;
}
struct node {
  int id, l, r, val;
} Hina[1000005], Aya[1000005];
int enemy[1005], f[1005], n, m, q, cnt;
int find(int x) { return x == f[x] ? x : f[x] = find(f[x]); }
bool cmp(node a, node b) { return a.val > b.val; }
int query(int L, int R) {
  for (int i = 1; i <= n; ++i) f[i] = i;
  memset(enemy, 0, sizeof(enemy));
  cnt = 0;
  for (int i = 1; i <= m; ++i) {
    if (Hina[i].id >= L && Hina[i].id <= R) {
      Aya[++cnt] = Hina[i];
    }
  }
  for (int i = 1; i <= cnt; ++i) {
    int u = Aya[i].l, v = Aya[i].r;
    if (find(u) == find(v)) {
      return Aya[i].val;
    }
    if (!enemy[u]) {
      enemy[u] = v;
    } else {
      f[find(enemy[u])] = find(v);
    }
    if (!enemy[v]) {
      enemy[v] = u;
    } else {
      f[find(enemy[v])] = find(u);
    }
  }
  return -1;
}
int main() {
  read(n), read(m), read(q);
  for (int i = 1; i <= m; ++i) {
    read(Hina[i].l), read(Hina[i].r), read(Hina[i].val);
    Hina[i].id = i;
  }
  sort(Hina + 1, Hina + m + 1, cmp);
  for (int i = 1, L, R; i <= q; ++i) {
    read(L), read(R);
    printf("%d\n", query(L, R));
  }
  return 0;
}
