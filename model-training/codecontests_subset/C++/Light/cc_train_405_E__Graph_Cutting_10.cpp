#include <bits/stdc++.h>
using namespace std;
struct edge {
  int to, nx;
} e[200050];
int head[200050];
int num = 0;
bool bo[200050];
void addedge(int x, int y) {
  e[num].to = y;
  e[num].nx = head[x];
  head[x] = num++;
}
bool ok[200050];
int gao(int now) {
  ok[now] = true;
  queue<int> q;
  for (int p = head[now]; p != -1; p = e[p].nx) {
    if (!bo[p]) {
      q.push(e[p].to);
      bo[p] = bo[p ^ 1] = true;
    }
  }
  queue<int> p;
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    int w = gao(u);
    if (w != 0)
      printf("%d %d %d\n", w, u, now);
    else
      p.push(u);
  }
  while (p.size() >= 2) {
    int u, v;
    u = p.front();
    p.pop();
    v = p.front();
    p.pop();
    printf("%d %d %d\n", u, now, v);
  }
  if (!p.empty())
    return p.front();
  else
    return 0;
}
int main() {
  int i, j, k, n, m;
  num = 0;
  memset(head, -1, sizeof(head));
  memset(ok, 0, sizeof(ok));
  memset(bo, 0, sizeof(bo));
  scanf("%d%d", &n, &m);
  for (i = 0; i < m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    addedge(x, y);
    addedge(y, x);
  }
  if (m % 2)
    printf("No solution\n");
  else {
    gao(1);
  }
}
