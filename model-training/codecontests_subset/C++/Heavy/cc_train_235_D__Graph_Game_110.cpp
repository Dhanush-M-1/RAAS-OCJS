#include <bits/stdc++.h>
using namespace std;
template <typename T>
void ckmax(T& a, T b) {
  if (b > a) a = b;
}
template <typename T>
void ckmin(T& a, T b) {
  if (b < a) a = b;
}
struct _in {
  const _in operator,(int& a) const {
    a = 0;
    char k = getchar();
    int f = 1;
    for (; !isdigit(k); k = getchar())
      if (k == '-') f = -1;
    for (; isdigit(k); k = getchar()) a = a * 10 + k - '0';
    a *= f;
    return *this;
  }
} in;
const int N = 3000 + 5;
int fr[N << 1], to[N << 1], h[N], tot;
void ade(int u, int v) {
  tot++;
  fr[tot] = h[u];
  to[tot] = v;
  h[u] = tot;
}
int n, stk[N], top, vis[N], dep[N], inc[N], C[N], Ctop;
;
void dfs1(int u, int f) {
  stk[++top] = u, vis[u] = 1, dep[u] = dep[f] + 1;
  for (int i = h[u]; i; i = fr[i])
    if (to[i] != f) {
      int v = to[i];
      if (vis[to[i]]) {
        if (dep[to[i]] > dep[u])
          continue;
        else
          for (int j = (dep[to[i]]); j <= (dep[u]); ++j)
            inc[stk[j]] = 1, C[++Ctop] = stk[j];
      } else
        dfs1(to[i], u);
    }
  top--;
}
double ans, tmp;
int rt;
void dfs2(int u, int f, int Y) {
  vis[u] = 1;
  if (Y <= 0 && dep[u] - 1)
    ans += tmp = (1.00 / (dep[u]));
  else if (dep[u] - 1)
    ans += tmp =
        (1.00 / (dep[u] - 1 + 1) + 1.00 / (dep[u] - 1 - Y + (Ctop - Y) + 1) -
         1.00 / (dep[u] - 1 - Y + Ctop));
  for (int i = h[u]; i; i = fr[i])
    if (to[i] != f) {
      if (vis[to[i]]) continue;
      if (!inc[to[i]]) {
        if (inc[u])
          dfs2(to[i], u, Y);
        else
          dfs2(to[i], u, Y);
      } else {
        if (!inc[u])
          dfs2(to[i], u, 0);
        else
          dfs2(to[i], u, Y + 1);
      }
    }
}
int main() {
  in, n;
  for (int i = (1); i <= (n); ++i) {
    int x, y;
    in, x, y;
    ++x, ++y;
    ade(x, y), ade(y, x);
  }
  for (int i = (1); i <= (n); ++i) {
    rt = i;
    memset(vis, 0, sizeof vis);
    dfs1(i, 0);
    memset(vis, 0, sizeof vis);
    dfs2(i, 0, inc[i] ? 0 : -1);
    memset(dep, 0, sizeof dep);
    Ctop = 0;
  }
  printf("%.10f\n", ans + n);
  return 0;
}
