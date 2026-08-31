#include <bits/stdc++.h>
using namespace std;
const int N = 3000 + 5;
int n;
int hd[N], to[N * 2], nxt[N * 2];
inline void add_se(int idx, int a, int b) {
  nxt[idx] = hd[a];
  hd[a] = idx;
  to[idx] = b;
}
int sz_circ, circ[N], at_circ[N], stk[N], stkfr[N], b_stk;
;
bool vis[N], incirc[N], e_incirc[N];
bool dfs_circ(int u, int f) {
  stk[++b_stk] = u;
  vis[u] = true;
  for (int e = hd[u]; e; e = nxt[e]) {
    int v = to[e];
    if (v == f) continue;
    if (vis[v]) {
      int vat = b_stk;
      while (stk[vat] != v) --vat;
      for (int i = vat; i <= b_stk; ++i) {
        circ[++sz_circ] = stk[i];
        incirc[stk[i]] = true;
        at_circ[stk[i]] = sz_circ;
      }
      e_incirc[e >> 1] = true;
      return true;
    }
    if (dfs_circ(v, u)) {
      if (incirc[u]) e_incirc[e >> 1] = true;
      return true;
    }
  }
  --b_stk;
  return false;
}
int inpart[N];
void dfs_part(int u, int f, int p) {
  inpart[u] = p;
  for (int e = hd[u]; e; e = nxt[e])
    if (!e_incirc[e >> 1]) {
      int v = to[e];
      if (v == f) continue;
      dfs_part(v, u, p);
    }
}
int cnt[N];
void dfs_cnt(int u, int f) {
  cnt[u] = cnt[f] + 1;
  for (int e = hd[u]; e; e = nxt[e])
    if (!e_incirc[e >> 1]) {
      int v = to[e];
      if (v == f) continue;
      dfs_cnt(v, u);
    }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    ++a, ++b;
    add_se(i << 1, a, b), add_se(i << 1 | 1, b, a);
  }
  dfs_circ(1, 0);
  for (int i = 1; i <= sz_circ; ++i) dfs_part(circ[i], 0, i);
  double ans = 0.;
  for (int i = 1; i <= n; ++i) {
    dfs_cnt(i, 0);
    for (int j = 1; j <= sz_circ; ++j)
      if (j != inpart[i]) {
        dfs_cnt(circ[j], 0);
      }
    for (int j = 1; j <= n; ++j) {
      if (inpart[j] == inpart[i])
        ans += 1. / cnt[j];
      else {
        int onepart = abs(inpart[i] - inpart[j]), cnt1 = cnt[j],
            cnt2 = cnt[circ[inpart[i]]];
        ans += 1. / (cnt1 + cnt2 + onepart - 1);
        ans += 1. / (cnt1 + cnt2 + sz_circ - onepart - 1);
        ans -= 1. / (cnt1 + cnt2 + sz_circ - 2);
      }
    }
  }
  printf("%.10f\n", ans);
  return 0;
}
