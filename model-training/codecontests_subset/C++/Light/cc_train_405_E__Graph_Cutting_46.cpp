#include <bits/stdc++.h>
using namespace std;
struct node {
  int t, nxt;
  bool block;
} edge[110000 << 1];
int headline[110000], E;
inline void add(int f, int t) {
  edge[E].t = t;
  edge[E].nxt = headline[f];
  edge[E].block = false;
  headline[f] = E++;
}
int n, m;
int dfs(int u) {
  vector<int> adj;
  for (int i = headline[u]; ~i; i = edge[i].nxt) {
    if (edge[i].block) continue;
    edge[i].block = edge[i ^ 1].block = true;
    adj.push_back(edge[i].t);
  }
  int ss = adj.size();
  queue<int> q;
  for (int i = 0; i < ss; i++) {
    int ww = dfs(adj[i]);
    if (ww == 0) {
      q.push(adj[i]);
    } else {
      printf("%d %d %d\n", u, adj[i], ww);
    }
  }
  int x = -1, y = -1;
  while (!q.empty()) {
    if (x == -1) {
      x = q.front();
      q.pop();
    } else {
      y = q.front();
      q.pop();
      printf("%d %d %d\n", x, u, y);
      x = y = -1;
    }
  }
  if (x == -1) return 0;
  return x;
}
void solve(void) {
  memset(headline, -1, sizeof(headline));
  E = 0;
  for (int i = 0; i < (m); i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    add(a, b);
    add(b, a);
  }
  if (m % 2) {
    printf("No solution\n");
    return;
  }
  dfs(1);
}
int main(void) {
  while (2 == scanf("%d%d", &n, &m)) solve();
}
