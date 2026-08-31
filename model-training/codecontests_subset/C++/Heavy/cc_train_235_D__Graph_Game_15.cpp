#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch ^ 48);
    ch = getchar();
  }
  return x * f;
}
const int N = 3100;
struct node {
  int nex, to;
} a[N << 1];
int n, m, tot, ccol, top, cnt;
int id[N], acc[N], fa[N], lca[N][N], maxid;
int dfn[N], low[N], col[N], vis[N], sta[N], num[N];
int head[N], dep[N];
void add(int f, int t) {
  a[++tot].nex = head[f];
  a[tot].to = t;
  head[f] = tot;
}
void tarjan(int now, int fa) {
  dfn[now] = low[now] = ++cnt;
  sta[++top] = now;
  vis[now] = 1;
  for (int i = head[now], to; i; i = a[i].nex) {
    to = a[i].to;
    if (to == fa) continue;
    if (!dfn[to]) {
      tarjan(to, now);
      low[now] = min(low[now], low[to]);
    } else if (vis[i])
      low[now] = min(low[now], dfn[to]);
  }
  if (dfn[now] == low[now]) {
    ccol++;
    int t;
    do {
      t = sta[top];
      vis[t] = 0;
      col[t] = ccol;
      num[ccol]++;
    } while (sta[top--] != now);
  }
}
int find(int x) { return x == fa[x] ? fa[x] : fa[x] = find(fa[x]); }
void Dfs(int now, int fa) {
  for (int i = head[now], to; i; i = a[i].nex) {
    to = a[i].to;
    if (to == fa) continue;
    dep[to] = dep[now] + 1;
    Dfs(to, now);
  }
}
void work(int now, int ac, int f) {
  acc[now] = ac;
  fa[now] = now;
  for (int i = head[now], to; i; i = a[i].nex) {
    to = a[i].to;
    if (to != f && num[col[to]] == 1) {
      dep[to] = dep[now] + 1;
      work(to, ac, now);
      if (find(to) != find(now)) fa[find(to)] = find(now);
    }
  }
  for (int i = 1; i <= n; i++)
    if (acc[i] == ac) lca[now][i] = lca[i][now] = find(i);
}
void dfs(int now, int fa) {
  id[now] = id[fa] + 1;
  dep[now] = 1;
  acc[now] = now;
  work(now, now, now);
  for (int i = head[now], to; i; i = a[i].nex) {
    to = a[i].to;
    if (to != fa && !id[to] && num[col[to]] > 1) dfs(to, now);
  }
}
int main() {
  n = read();
  m = n;
  for (int i = 1, x, y; i <= m; i++) {
    x = read() + 1;
    y = read() + 1;
    add(x, y);
    add(y, x);
  }
  if (m == n - 1) {
    double res = 0;
    for (int i = 1; i <= n; i++) {
      dep[i] = 1;
      Dfs(i, 0);
      for (int j = 1; j <= n; j++) res += (double)1 / (double)dep[j];
    }
    printf("%.5f\n", res);
  } else {
    double Ans = 0;
    for (int i = 1; i <= n; i++)
      if (!dfn[i]) tarjan(i, 0);
    for (int i = 1; i <= n; i++)
      if (num[col[i]] > 1) {
        id[i] = 1;
        maxid = num[col[i]];
        dfs(i, 0);
        break;
      }
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++) {
        if (acc[i] == acc[j])
          Ans += 1.0 / (dep[i] + dep[j] - 2 * dep[lca[i][j]] + 1);
        else {
          int x = dep[i] + dep[j], y = abs(id[acc[i]] - id[acc[j]]) - 1,
              z = maxid - y - 2;
          Ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
        }
      }
    printf("%.5f\n", Ans);
  }
  fclose(stdin);
  fclose(stdout);
  return 0;
}
