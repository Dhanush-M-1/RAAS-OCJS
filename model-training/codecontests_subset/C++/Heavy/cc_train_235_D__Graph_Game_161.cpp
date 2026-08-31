#include <bits/stdc++.h>
using namespace std;
const int N = 3 * 1e3 + 10;
int v[N << 1];
int x[N << 1];
int ct;
int al[N];
bool isr[N];
int n;
int tot;
int ed;
int st;
double ans;
inline void add(int u, int V) {
  v[++ct] = V;
  x[ct] = al[u];
  al[u] = ct;
}
struct bcj {
  int fa[N];
  inline void ih() {
    for (int i = 1; i <= n; i++) fa[i] = i;
  }
  inline int f(int x) { return fa[x] = (fa[x] == x) ? x : f(fa[x]); }
  inline bool u(int x, int y) {
    x = f(x);
    y = f(y);
    if (x == y) return false;
    fa[x] = y;
    return true;
  }
} s;
inline void dfs(int u, int f, int dep1, int dep2) {
  dep1++;
  dep2 += isr[u];
  if (dep2 == 0 || dep2 == 1)
    ans += 1.0 / (dep1);
  else {
    ans += 1.0 / dep1;
    ans += 1.0 / (dep1 - dep2 + (tot - dep2));
    ans -= 1.0 / (dep1 + (tot - dep2 - 2));
  }
  for (int i = al[u]; i; i = x[i])
    if (v[i] != f) dfs(v[i], u, dep1, dep2);
}
inline bool mrk(int u, int tar, int f) {
  if (u == tar) {
    return isr[u] = true;
  }
  for (int i = al[u]; i; i = x[i])
    if (v[i] != f)
      if (mrk(v[i], tar, u)) return isr[u] = true;
  return false;
}
int main() {
  scanf("%d", &n);
  s.ih();
  for (int i = 1, u, v; i <= n; i++) {
    scanf("%d%d", &u, &v);
    u++;
    v++;
    if (s.u(u, v) == false)
      st = u, ed = v;
    else
      add(u, v), add(v, u);
  }
  mrk(st, ed, 0);
  for (int i = 1; i <= n; i++) tot += isr[i];
  tot += 2;
  for (int i = 1; i <= n; i++) {
    dfs(i, 0, 0, 0);
  }
  printf("%.10lf", ans);
  return 0;
}
