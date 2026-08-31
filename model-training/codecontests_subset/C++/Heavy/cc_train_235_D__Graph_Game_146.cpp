#include <bits/stdc++.h>
using namespace std;
struct graph {
  int nxt, to;
} e[3005 << 1];
int g[3005], t[3005], d1[3005], d2[3005], n, cnt;
bool ins[3005];
double ans;
queue<int> q;
inline int read() {
  int ret = 0;
  char c = getchar();
  while (!isdigit(c)) c = getchar();
  while (isdigit(c)) {
    ret = (ret << 1) + (ret << 3) + c - '0';
    c = getchar();
  }
  return ret;
}
inline void addedge(int x, int y) {
  e[++cnt].nxt = g[x];
  g[x] = cnt;
  e[cnt].to = y;
}
inline void toposort() {
  int u;
  for (int i = 1; i <= n; ++i)
    if (t[i] == 1) q.push(i);
  while (!q.empty()) {
    u = q.front();
    q.pop();
    ++cnt;
    for (int i = g[u]; i; i = e[i].nxt)
      if ((--t[e[i].to] == 1)) q.push(e[i].to);
  }
}
inline void dfs(int u) {
  ins[u] = true;
  for (int i = g[u]; i; i = e[i].nxt)
    if (!ins[e[i].to]) {
      d2[e[i].to] = d2[u] + 1;
      if (!d1[e[i].to]) {
        d1[e[i].to] = d1[u] + 1;
        ans += 1.0 / (double)(d1[e[i].to]);
      } else {
        ans += 1.0 / (double)(d2[e[i].to]) -
               2.0 / (double)(d1[e[i].to] + d2[e[i].to] + cnt - 2);
      }
      dfs(e[i].to);
    }
  ins[u] = false;
}
inline void Aireen() {
  n = read();
  for (int i = 1, j, k; i <= n; ++i) {
    j = read() + 1;
    k = read() + 1;
    addedge(j, k);
    addedge(k, j);
    ++t[j];
    ++t[k];
  }
  cnt = 0;
  toposort();
  cnt = n - cnt;
  for (int i = 1; i <= n; ++i) {
    memset(d1, 0, sizeof(d1));
    memset(d2, 0, sizeof(d2));
    d1[i] = d2[i] = 1;
    dfs(i);
  }
  printf("%.8lf\n", ans + n);
}
int main() {
  Aireen();
  return 0;
}
