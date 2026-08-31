#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3 * 100100, MAXM = 5 * 100100;
int n, m, p[MAXN];
set<int> x[MAXN];
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; ++i) scanf("%d", &p[i]);
  for (int i = 1, u, v; i <= m; ++i) scanf("%d %d", &u, &v), x[u].insert(v);
  int pos = n;
  for (int i = n - 1; i >= 1; --i) {
    bool flg = true;
    for (int j = i + 1; j <= pos; ++j)
      if (x[p[i]].find(p[j]) == x[p[i]].end()) {
        flg = false;
        break;
      }
    if (!flg) continue;
    for (int j = i + 1; j <= pos; ++j) swap(p[j - 1], p[j]);
    pos--;
  }
  printf("%d\n", n - pos);
}
