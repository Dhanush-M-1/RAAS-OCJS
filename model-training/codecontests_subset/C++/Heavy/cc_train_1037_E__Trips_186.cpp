#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int u, v, nxt;
} e[400010];
int tot;
int first[200010];
int d[200010];
void build(int u, int v) {
  e[++tot] = (Edge){u, v, first[u]};
  first[u] = tot;
  d[u]++;
  return;
}
int ans[200010];
bool book[200010];
bool is[200010];
int n, m, k;
queue<int> q;
void getans(int w) {
  if (w < m) {
    ans[w] = ans[w + 1];
    int u = e[(w + 1) * 2].u, v = e[(w + 1) * 2].v;
    if (book[w + 1]) return;
    d[u]--;
    d[v]--;
    book[w + 1] = true;
    if (!is[u] && d[u] < k) q.push(u), ans[w]--, is[u] = true;
    if (!is[v] && d[v] < k) q.push(v), ans[w]--, is[v] = true;
  } else {
    ans[w] = n;
    for (int i = 1; i <= n; i++)
      if (d[i] < k) q.push(i), ans[w]--, is[i] = true;
  }
  while (!q.empty()) {
    int now = q.front();
    q.pop();
    for (int i = first[now]; i; i = e[i].nxt) {
      if (book[(i + 1) / 2]) continue;
      if (is[e[i].v]) continue;
      book[(i + 1) / 2] = true;
      d[e[i].v]--;
      if (d[e[i].v] < k) {
        q.push(e[i].v);
        ans[w]--;
        is[e[i].v] = true;
      }
    }
  }
  return;
}
int main() {
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    build(u, v);
    build(v, u);
  }
  for (int i = m; i >= 1; i--) getans(i);
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
