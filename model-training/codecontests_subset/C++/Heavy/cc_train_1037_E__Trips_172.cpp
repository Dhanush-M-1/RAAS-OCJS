#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int maxn = 1e6 + 5;
struct edge {
  int u, v, ne, num;
} e[maxn];
int n, m, k, sum;
int d[maxn], no[maxn], vis[maxn];
int head[maxn], len;
int ans[maxn];
void add(int u, int v, int num) {
  e[len].u = u;
  e[len].v = v;
  e[len].num = num;
  e[len].ne = head[u];
  head[u] = len++;
}
void del(int x) {
  sum--;
  no[x] = 1;
  for (int i = head[x]; i != -1; i = e[i].ne) {
    int v = e[i].v;
    if (no[v] || vis[e[i].num]) continue;
    vis[e[i].num] = 1;
    d[v]--;
    if (d[v] < k) del(v);
  }
  return;
}
int main() {
  memset(head, -1, sizeof(head));
  cin >> n >> m >> k;
  for (int i = 1, x, y; i <= m; i++) {
    scanf("%d %d", &x, &y);
    add(x, y, i);
    add(y, x, i);
    d[x]++;
    d[y]++;
  }
  sum = n;
  for (int i = 1; i <= n; i++) {
    if (d[i] >= k || no[i]) continue;
    del(i);
  }
  ans[m] = sum;
  for (int i = len - 1; i > 0; i -= 2) {
    int u = e[i].u, v = e[i].v;
    if (!vis[e[i].num]) {
      vis[e[i].num] = 1;
      if (!no[u]) {
        d[u]--;
        if (d[u] < k) del(u);
      }
      if (!no[v]) {
        d[v]--;
        if (d[v] < k) del(v);
      }
    }
    ans[(i + 1) / 2 - 1] = sum;
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
