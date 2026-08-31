#include <bits/stdc++.h>
using namespace std;
inline int read() {
  register int x = 0, f = 1;
  register char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = 0;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + (ch ^ '0');
    ch = getchar();
  }
  return f ? x : -x;
}
int n, k, f[80][80], w[80][80], c[80][80], ans, vis[80];
struct node {
  int a, b, id;
} p[80];
vector<int> C[80][80], ansp;
int main() {
  for (int T = (1), _ed = (read()); T <= _ed; ++T) {
    memset(vis, 0, sizeof vis);
    n = read(), k = read();
    ans = 0;
    ansp.clear();
    for (int i = (1), _ed = (n); i <= _ed; ++i)
      p[i] = (node){read(), read(), i};
    sort(p + 1, p + n + 1, [&](node x, node y) { return x.b < y.b; });
    for (int i = (1), _ed = (n); i <= _ed; ++i)
      for (int j = (1), _ed = (k - 1); j <= _ed; ++j)
        w[i][j] = -(k - j) * p[i].b + p[i].a;
    for (int l = (1), _ed = (n); l <= _ed; ++l) {
      memset(f, -0x3f, sizeof f);
      f[0][0] = 0, C[0][0].clear();
      int t = 0;
      for (int i = (1), _ed = (n); i <= _ed; ++i) {
        if (i == l) continue;
        ++t;
        for (int j = (0), _ed = (min(t, k - 1)); j <= _ed; ++j) {
          f[t][j] = f[t - 1][j];
          C[t][j] = C[t - 1][j];
          if (j) {
            int tmp = f[t - 1][j - 1] + w[i][j];
            if (f[t][j] < tmp) {
              f[t][j] = tmp;
              C[t][j] = C[t - 1][j - 1];
              C[t][j].push_back(p[i].id);
            }
          }
        }
      }
      int res = f[t][k - 1];
      for (int i = (1), _ed = (n); i <= _ed; ++i) res += (k - 1) * p[i].b;
      res += p[l].a;
      C[t][k - 1].push_back(p[l].id);
      if (ans < res) {
        ans = res;
        ansp = C[t][k - 1];
      }
    }
    int m = (int)(ansp).size();
    printf("%d\n", n + n - m);
    for (int i = (0), _ed = (m - 2); i <= _ed; ++i)
      printf("%d ", ansp[i]), vis[ansp[i]] = 1;
    vis[ansp.back()] = 1;
    for (int i = (1), _ed = (n); i <= _ed; ++i)
      if (!vis[i]) printf("%d %d ", i, -i);
    printf("%d\n", ansp.back());
  }
  return 0;
}
