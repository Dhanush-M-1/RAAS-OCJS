#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int a[N], b[N], c[N], d[N], e[N];
using VI = vector<int>;
VI v[N], rep[N];
int rn;
void search(int u) {
  for (int U; !v[u].empty();) {
    U = v[u].back();
    v[u].pop_back();
    search(a[U]);
    rep[rn].push_back(U);
  }
}
int main() {
  int n, s, m;
  scanf("%d %d", &n, &s);
  for (int i = 1; i <= n; i++) {
    scanf("%d", a + i);
    c[i] = a[i];
    d[i] = i;
  }
  sort(c + 1, c + n + 1);
  m = unique(c + 1, c + n + 1) - c - 1;
  for (int i = 1; i <= n; i++) {
    b[i] = a[i] = lower_bound(c + 1, c + m + 1, a[i]) - c;
  }
  sort(b + 1, b + n + 1);
  for (int i = 1; i <= n; i++) {
    if (a[i] != b[i]) {
      v[b[i]].push_back(i);
    }
  }
  for (int i = 1; i <= m; i++) {
    if (!v[i].empty()) {
      search(i);
      int f = rep[rn].size();
      for (int j = 0; j < f; j++) {
        d[rep[rn][j == f - 1 ? 0 : j + 1]] = rep[rn][j];
      }
      s -= f;
      rn++;
    }
    if (s < 0) {
      puts("-1");
      return 0;
    }
  }
  s = min(rn, s);
  if (s >= 2) {
    printf("%d\n", rn - s + 2);
    {
      printf("%d\n", s);
      for (int i = 0; i < s; i++) {
        printf("%d%c", rep[i][0], i + 1 < s ? ' ' : '\n');
      }
      a[N - 1] = d[rep[s - 1][0]];
      for (int i = s; --i;) {
        d[rep[i][0]] = d[rep[i - 1][0]];
      }
      d[rep[0][0]] = a[N - 1];
    }
  } else {
    printf("%d\n", rn);
  }
  VI g;
  for (int i = 1; i <= n; i++) {
    if (d[i] == i) continue;
    if (e[i]) continue;
    g.clear();
    for (int j = i; !e[j];) {
      g.push_back(j);
      e[j] = 1;
      j = d[j];
    }
    printf("%d\n", g.size());
    for (int j = 0; j < g.size(); j++) {
      printf("%d%c", g[j], j + 1 < g.size() ? ' ' : '\n');
    }
  }
  return 0;
}
