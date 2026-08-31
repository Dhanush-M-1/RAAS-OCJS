#include <bits/stdc++.h>
using namespace std;
const int maxn = 200100;
struct node {
  int v, u;
} e[maxn + 10];
set<int> s[maxn];
int k, ans, in[maxn], vis[maxn], ret[maxn], n, m;
queue<int> q;
void dele(int x) {
  set<int>::iterator iter;
  int u, v;
  if (vis[x] || in[x] >= k) return;
  vis[x] = 1;
  q.push(x);
  --ans;
  while (!q.empty()) {
    u = q.front();
    q.pop();
    for (iter = s[u].begin(); iter != s[u].end(); iter++) {
      v = *iter;
      in[v]--;
      if (in[v] < k && !vis[v]) {
        vis[v] = 1;
        q.push(v);
        --ans;
      }
    }
  }
}
int main() {
  int i;
  scanf("%d%d%d", &n, &m, &k);
  memset(in, 0, sizeof(in));
  for (i = 1; i <= m; i++) {
    scanf("%d%d", &e[i].u, &e[i].v);
    s[e[i].u].insert(e[i].v);
    s[e[i].v].insert(e[i].u);
    in[e[i].u]++;
    in[e[i].v]++;
  }
  memset(vis, 0, sizeof(vis));
  for (i = 1; i <= n; i++) {
    dele(i);
  }
  ans = 0;
  for (i = 1; i <= n; i++) {
    if (!vis[i]) ans++;
  }
  ret[m] = ans;
  for (i = m; i >= 1; i--) {
    if (!vis[e[i].v]) in[e[i].u]--;
    if (!vis[e[i].u]) in[e[i].v]--;
    s[e[i].u].erase(e[i].v);
    s[e[i].v].erase(e[i].u);
    dele(e[i].u);
    dele(e[i].v);
    ret[i - 1] = ans;
  }
  for (i = 1; i <= m; i++) {
    printf("%d\n", ret[i]);
  }
  return 0;
}
