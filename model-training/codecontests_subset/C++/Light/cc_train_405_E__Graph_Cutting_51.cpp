#include <bits/stdc++.h>
using namespace std;
struct edg {
  int v, nxt;
} E[100004 * 2];
int hd[100004], ide;
int s[100004];
void adde(int u, int v) {
  E[ide].v = v;
  E[ide].nxt = hd[u];
  hd[u] = ide++;
}
void init() {
  memset(hd, -1, sizeof(hd));
  memset(s, 0, sizeof(s));
  ide = 0;
}
int dfs(int u, int f) {
  s[u] = 1;
  int pre = 0;
  for (int i = hd[u]; ~i; i = E[i].nxt) {
    int v;
    if ((v = E[i].v) != f && s[v] < 2) {
      int q = (s[v] == 1) ? 0 : dfs(v, u);
      if (q)
        printf("%d %d %d\n", u, v, q);
      else if (pre)
        printf("%d %d %d\n", pre, u, v), pre = 0;
      else
        pre = v;
    }
  }
  s[u] = 2;
  return pre;
}
int n, m;
int main() {
  while (~scanf("%d%d", &n, &m)) {
    init();
    for (int i = 0; i < m; ++i) {
      int u, v;
      scanf("%d%d", &u, &v);
      adde(u, v);
      adde(v, u);
    }
    if (m % 2)
      puts("No solution");
    else
      dfs(1, -1);
  }
  return 0;
}
