#include <bits/stdc++.h>
using namespace std;
const int MAXN = 501 * 1001;
vector<pair<pair<int, int>, pair<int, int> > > yal;
int par[MAXN] = {}, col[MAXN] = {};
int root(int x) {
  if (par[x] < 0) {
    return x;
  }
  int p = root(par[x]);
  col[x] ^= col[par[x]];
  return par[x] = p;
}
int main() {
  int n, q, m, l, r;
  scanf("%d%d%d", &n, &m, &q);
  int x, y, z;
  for (int i = 0; i < m; i++)
    scanf("%d%d%d", &x, &y, &z), yal.push_back({{z, i}, {x, y}});
  sort(yal.rbegin(), yal.rend());
  for (int i = 0; i < q; i++) {
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= n; i++) par[i] = -1, col[i] = 0;
    bool f = 1;
    for (int j = 0; j < m && f; j++) {
      if (yal[j].first.second >= l - 1 && yal[j].first.second < r) {
        x = yal[j].second.first, y = yal[j].second.second;
        if (root(x) == root(y)) {
          if (col[x] == col[y]) printf("%d\n", yal[j].first.first), f = 0;
        } else {
          bool ff = 0;
          if (col[x] == col[y]) ff = 1;
          x = root(x);
          y = root(y);
          if (par[y] < par[x]) swap(x, y);
          par[x] += par[y];
          if (ff) {
            col[y] = 1;
          }
          par[y] = x;
        }
      }
    }
    if (f) puts("-1");
  }
}
