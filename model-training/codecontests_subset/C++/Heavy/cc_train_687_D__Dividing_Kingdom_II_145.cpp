#include <bits/stdc++.h>
using namespace std;
const int N = 1111, M = N * N / 2;
int n, m, q;
int u[M], v[M], w[M], u0[M], v0[M], w0[M];
int order[M];
int p[N], h[N];
bool rel[N];
int find(int x) {
  int root;
  bool rel_root = 0;
  for (root = x; p[root] != root; root = p[root]) rel_root ^= rel[root];
  for (; x != root;) {
    bool rel_x = rel[x];
    rel[x] = rel_root;
    rel_root ^= rel_x;
    int px = p[x];
    p[x] = root;
    x = px;
  }
  return root;
}
__inline bool add(int e) {
  int fu = find(u[e]), fv = find(v[e]);
  if (fu == fv)
    if (rel[u[e]] == rel[v[e]]) {
      return 0;
    } else
      ;
  else {
    if (h[fu] > h[fv]) swap(fu, fv);
    p[fu] = fv;
    h[fv] += h[fv] == h[fu];
    rel[fu] = rel[u[e]] ^ rel[v[e]] ^ 1;
  }
  return 1;
}
__inline bool cmp(int x, int y) { return w0[x] > w0[y]; }
inline void getint(int &x) {
  char ch;
  for (; !isdigit(ch = getchar());)
    ;
  x = ch - '0';
  for (; isdigit(ch = getchar());) x = x * 10 + ch - '0';
}
int unsolved[N], cu;
int main() {
  getint(n);
  getint(m);
  getint(q);
  int cp = 0;
  for (int i = 1; i <= m; i++) {
    order[i] = i;
    getint(u0[i]);
    getint(v0[i]);
    getint(w0[i]);
  }
  sort(order + 1, order + m + 1, cmp);
  for (int i = 1; i <= m; i++) {
    u[i] = u0[order[i]];
    v[i] = v0[order[i]];
    w[i] = w0[order[i]];
  }
  for (int k = 1; k <= q; ++k) {
    int l, r, ans;
    getint(l);
    getint(r);
    for (int i = 1; i <= n; i++) p[i] = i, h[i] = 1, rel[i] = 0;
    ans = -1;
    for (int e = 1; e <= m; e++) {
      if (order[e] >= l && order[e] <= r)
        if (!add(e)) {
          ans = w[e];
          break;
        }
    }
    printf("%d\n", ans);
  }
  return 0;
}
