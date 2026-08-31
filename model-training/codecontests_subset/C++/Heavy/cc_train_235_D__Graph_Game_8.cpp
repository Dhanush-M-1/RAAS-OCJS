#include <bits/stdc++.h>
using namespace std;
static const int maxn = 3000 + 5;
static const int maxm = 6000 + 5;
static int n, c;
static int suf[maxn], pre[maxm], tar[maxm], e;
static int vis[maxn], dep[maxn], dis[maxn];
static int deg[maxn], que[maxn], head, tail;
static double ans;
inline int read() {
  int k = 0, f = 1;
  char c = getchar();
  while (c > '9' || c < '0') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c <= '9' && c >= '0') {
    k = k * 10 + c - '0';
    c = getchar();
  }
  return k * f;
}
void dfs(int u) {
  vis[u] = 1;
  for (int i = suf[u]; i; i = pre[i])
    if (!vis[tar[i]]) {
      dep[tar[i]] = dep[u] + 1;
      if (!dis[tar[i]]) {
        dis[tar[i]] = dis[u] + 1;
        ans += 1.0 / dis[tar[i]];
      } else
        ans += 1.0 / dep[tar[i]] - 2.0 / (dis[tar[i]] + dep[tar[i]] + c - 2);
      dfs(tar[i]);
    }
  vis[u] = 0;
}
int main() {
  n = read();
  for (int u, v, i = 1; i <= n; ++i) {
    ++deg[u = read() + 1];
    ++deg[v = read() + 1];
    pre[++e] = suf[u], suf[u] = e, tar[e] = v;
    pre[++e] = suf[v], suf[v] = e, tar[e] = u;
  }
  for (int i = 1; i <= n; ++i)
    if (deg[i] == 1) que[tail++] = i;
  while (head != tail)
    for (int i = suf[que[head++]]; i; i = pre[i])
      if (--deg[tar[i]] == 1) que[tail++] = tar[i];
  c = n - tail;
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= n; ++j) dis[j] = dep[j] = 0;
    dis[i] = dep[i] = 1;
    dfs(i);
  }
  printf("%.10lf", ans + n);
  return 0;
}
