#include <bits/stdc++.h>
using namespace std;
int n, m, cnt, k, tot, tp;
int head[200005];
int sta[200005];
int dgr[200005];
int ans[200005];
bool usd[200005];
struct node {
  int fr;
  int to;
  int nxt;
  int mrk;
} edge[400005];
void init() {
  cnt = 0;
  memset(head, -1, sizeof(head));
}
void addedge(int f, int t) {
  cnt++;
  edge[cnt].fr = f;
  edge[cnt].to = t;
  edge[cnt].nxt = head[f];
  head[f] = cnt;
}
queue<int> que;
int main() {
  init();
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    addedge(u, v);
    addedge(v, u);
    dgr[v]++;
    dgr[u]++;
  }
  for (int i = 1; i <= n; i++) {
    if (dgr[i] < k) {
      que.push(i);
    }
  }
  tot = n;
  tp = m;
  while (!que.empty()) {
    int u = que.front();
    que.pop();
    if (usd[u]) continue;
    usd[u] = true;
    tot--;
    for (int i = head[u]; i != -1; i = edge[i].nxt) {
      int v = edge[i].to;
      dgr[v]--;
      if (dgr[v] < k) {
        que.push(v);
      }
    }
  }
  for (int i = cnt - 1; i >= 1; i -= 2) {
    ans[tp--] = tot;
    int u = edge[i].fr;
    int v = edge[i].to;
    if (usd[u] || usd[v]) continue;
    dgr[u]--, dgr[v]--;
    edge[i].mrk = edge[i + 1].mrk = 1;
    if (dgr[u] < k) que.push(u);
    if (dgr[v] < k) que.push(v);
    while (!que.empty()) {
      int s = que.front();
      que.pop();
      if (usd[s]) continue;
      usd[s] = true;
      tot--;
      for (int i = head[s]; i != -1; i = edge[i].nxt) {
        if (edge[i].mrk) continue;
        int v = edge[i].to;
        dgr[v]--;
        if (dgr[v] < k) {
          que.push(v);
        }
      }
    }
  }
  for (int i = 1; i <= m; i++) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
