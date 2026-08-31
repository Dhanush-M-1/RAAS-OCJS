#include <bits/stdc++.h>
using namespace std;
const int maxn = 100005;
const int maxm = 200005;
const int maxlog = 20;
const long long P = 1000000007ll;
const int inf = 2147483647;
const double eps = 1e-6;
const long long INF = 9223372036854775807ll;
int n, m, ee = 1, h[maxn], inst[maxn], vis[maxn], cho[maxn], hav[maxn],
          cnt[maxn], mark[maxn], ok[maxn], mark2[maxn], tar[maxn];
struct Edge {
  int v, next;
} e[maxm];
void addedge(int u, int v) {
  e[ee] = Edge{v, h[u]};
  h[u] = ee++;
}
int check(int u) {
  inst[u] = vis[u] = 1;
  int sz = 1;
  for (register int i = h[u]; i; i = e[i].next) {
    if (vis[e[i].v] && !inst[e[i].v]) return -1;
    if (vis[e[i].v]) continue;
    int szz = check(e[i].v);
    if (szz != -1)
      sz += szz;
    else
      return -1;
  }
  inst[u] = 0;
  return sz;
}
void dfs1(int u) {
  vis[u] = 1;
  for (register int i = h[u]; i; i = e[i].next) {
    if (vis[e[i].v]) {
      mark[e[i].v]--;
      mark[u]++;
      mark2[e[i].v] -= e[i].v;
      mark2[u] += e[i].v;
      continue;
    }
    dfs1(e[i].v);
  }
}
pair<int, int> dfs2(int u) {
  vis[u] = 1;
  cnt[u] = mark[u];
  tar[u] = mark2[u];
  for (register int i = h[u]; i; i = e[i].next) {
    if (vis[e[i].v]) continue;
    pair<int, int> x = dfs2(e[i].v);
    cnt[u] += x.first, tar[u] += x.second;
  }
  return make_pair(cnt[u], tar[u]);
}
int dfs3(int u) {
  vis[u] = 1;
  if (cnt[u] == 1 && ok[tar[u]]) ok[u] = 1;
  int sz = 0;
  for (register int i = h[u]; i; i = e[i].next) {
    if (vis[e[i].v]) continue;
    sz += dfs3(e[i].v);
  }
  sz += ok[u];
  return sz;
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d", &n, &m);
    memset(cho, 0, sizeof(int) * (n + 2));
    memset(cnt, 0, sizeof(int) * (n + 2));
    memset(mark, 0, sizeof(int) * (n + 2));
    memset(mark2, 0, sizeof(int) * (n + 2));
    memset(cnt, 0, sizeof(int) * (n + 2));
    memset(tar, 0, sizeof(int) * (n + 2));
    memset(ok, 0, sizeof(int) * (n + 2));
    memset(hav, 0, sizeof(int) * (n + 2));
    memset(h, 0, sizeof(int) * (n + 2));
    ee = 1;
    for (register int i = 0; i < (m); ++i) {
      int u, v;
      scanf("%d%d", &u, &v);
      addedge(u, v);
    }
    for (register int i = 0; i < (min(100, n)); ++i) {
      int op = rand() % 2, u;
      if (n >= 60000) {
        if (op)
          u = rand() % (n / 2) + 1;
        else
          u = rand() % (n - n / 2) + n / 2 + 1;
      } else
        u = rand() % n + 1;
      while (hav[u]) {
        u++;
        if (u > n) u = 1;
      }
      cho[i] = u;
      hav[u] = 1;
    }
    int r = 0;
    for (register int i = 0; i < (min(100, n)); ++i) {
      memset(vis, 0, sizeof(int) * (n + 2));
      if (check(cho[i]) == n) {
        r = cho[i];
        break;
      }
    }
    if (!r)
      printf("-1\n");
    else {
      ok[0] = 1;
      memset(vis, 0, sizeof(int) * (n + 2));
      dfs1(r);
      memset(vis, 0, sizeof(int) * (n + 2));
      dfs2(r);
      memset(vis, 0, sizeof(int) * (n + 2));
      cnt[r] = 1;
      int ans = dfs3(r);
      if (5 * ans < n)
        printf("-1\n");
      else {
        for (register int i = 1; i < (n + 1); ++i) {
          if (ok[i]) printf("%d ", i);
        }
        printf("\n");
      }
    }
  }
}
